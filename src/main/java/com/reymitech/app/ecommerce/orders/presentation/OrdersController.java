package com.reymitech.app.ecommerce.orders.presentation;

import com.reymitech.app.ecommerce.orders.application.usecase.ChangeOrderStatusUseCase;
import com.reymitech.app.ecommerce.orders.application.usecase.CreateOrderUseCase;
import com.reymitech.app.ecommerce.orders.application.usecase.FindAllOrderUseCase;
import com.reymitech.app.ecommerce.orders.application.usecase.FindByIdOrderUseCase;
import com.reymitech.app.ecommerce.orders.domain.dtos.OrderDetailsDto;
import com.reymitech.app.ecommerce.orders.domain.dtos.OrderDto;
import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import com.reymitech.app.ecommerce.orders.presentation.request.CreateOrderRequest;
import com.reymitech.app.ecommerce.orders.presentation.request.StatusOrderRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final CreateOrderUseCase createOrderUseCase;
    private final FindAllOrderUseCase findAllOrderUseCase;
    private final FindByIdOrderUseCase findByIdOrderUseCase;
    private final ChangeOrderStatusUseCase changeOrderStatusUseCase;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    public void createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        createOrderUseCase.execute(createOrderRequest);
    }

    @GetMapping
    public ResponseEntity<Flux<OrderDto>> getOrders() {
        return ResponseEntity.ok(Flux.fromIterable(findAllOrderUseCase.findAll()).map(order -> modelMapper.map(order, OrderDto.class)));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<Mono<OrderDetailsDto>> getOrderDetails(@PathVariable String id) {
        return ResponseEntity.ok(Mono.just(findByIdOrderUseCase.findById(id)).map(order -> modelMapper.map(order, OrderDetailsDto.class)));
    }

    @PostMapping("/{id}/status")
    public void changeOrderStatus(@PathVariable String id, @RequestBody StatusOrderRequest statusOrder) {
        StatusOrder status = StatusOrder.valueOf(statusOrder.getStatusOrder().toUpperCase());
        changeOrderStatusUseCase.execute(id, status);
    }

    @PostMapping("/{id}/cancel")
    public void cancelOrder(@PathVariable String id) {
        changeOrderStatusUseCase.execute(id, StatusOrder.CANCELLED);
    }

}
