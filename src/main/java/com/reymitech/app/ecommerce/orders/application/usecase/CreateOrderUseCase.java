package com.reymitech.app.ecommerce.orders.application.usecase;

import com.reymitech.app.ecommerce.orders.domain.dtos.ProductDto;
import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import com.reymitech.app.ecommerce.orders.domain.models.Order;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderValidationService;
import com.reymitech.app.ecommerce.orders.presentation.request.CreateOrderRequest;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import com.reymitech.app.ecommerce.utils.exceptions.GeneralExceptionHandler;
import com.reymitech.app.ecommerce.utils.exceptions.GenericErrorResponse;
import com.reymitech.app.ecommerce.utils.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreateOrderUseCase {
    private final IOrderRepositoryPort orderRepositoryPort;
    private final IProductRepositoryPort productRepositoryPort;
    private final IOrderValidationService orderValidationService;

    @Transactional
    public void execute(CreateOrderRequest createOrderRequest) {
        boolean isValidTotal = orderValidationService.isValidTotal(createOrderRequest);

        List<ProductDto> products = productRepositoryPort.findAllProducts().stream()
                .map(product -> new ProductDto(product.getId(), product.getStock()))
                .toList();

        List<String> existStockProducts = orderValidationService.existStockProducts(createOrderRequest, products);

        if (!existStockProducts.isEmpty()) {
            throw new GenericErrorResponse("Existen productos sin stock: " + existStockProducts, HttpStatus.BAD_REQUEST);
        }

        if (!isValidTotal) {
            throw new GenericErrorResponse("El monto total de la orden no coincide con el total de los productos solicitados", HttpStatus.BAD_REQUEST);
        }

        createOrder(createOrderRequest);

        updateProductStock(createOrderRequest);
    }

    private void updateProductStock(CreateOrderRequest createOrderRequest) {
        createOrderRequest.getProducts().forEach(productOrderRequest -> {
            var productDto = productRepositoryPort.findById(productOrderRequest.getId());
            productDto.setStock(productDto.getStock() - productOrderRequest.getQuantity());
            productRepositoryPort.save(productDto);
        });
    }

    private void createOrder(CreateOrderRequest createOrderRequest) {
        Order order = Order.builder()
                .clientId(createOrderRequest.getClientId())
                .products(createOrderRequest.getProducts())
                .total(createOrderRequest.getTotal())
                .status(StatusOrder.PENDING)
                .build();

        orderRepositoryPort.save(order);
    }
}
