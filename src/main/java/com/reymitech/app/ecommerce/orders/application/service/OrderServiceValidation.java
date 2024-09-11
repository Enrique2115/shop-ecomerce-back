package com.reymitech.app.ecommerce.orders.application.service;

import com.reymitech.app.ecommerce.orders.domain.dtos.ProductDto;
import com.reymitech.app.ecommerce.orders.presentation.request.ProductOrderRequest;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderValidationService;
import com.reymitech.app.ecommerce.orders.presentation.request.CreateOrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceValidation implements IOrderValidationService {
    @Override
    public boolean isValidTotal(CreateOrderRequest createOrderRequest) {
        double total = createOrderRequest.getProducts().stream()
                .mapToDouble(productDto -> productDto.getPrice() * productDto.getQuantity())
                .sum();

        return total == createOrderRequest.getTotal();
    }

    @Override
    public List<String> existStockProducts(CreateOrderRequest createOrderRequest, List<ProductDto> products) {
        Map<String, ProductDto> productMap = products.stream()
                .collect(Collectors.toMap(ProductDto::getId, productDto -> productDto));

        return createOrderRequest.getProducts().stream()
                .filter(productOrderRequest -> {
                    ProductDto productDto = productMap.get(productOrderRequest.getId());
                    return productDto == null || productDto.getStock() < productOrderRequest.getQuantity();
                })
                .map(ProductOrderRequest::getName)
                .toList();
    }
}
