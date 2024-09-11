package com.reymitech.app.ecommerce.orders.application.usecase;

import com.reymitech.app.ecommerce.orders.domain.models.Order;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllOrderUseCase {
    private final IOrderRepositoryPort orderRepositoryPort;

    public List<Order> findAll() {
        return orderRepositoryPort.findAllOrders();
    }

}
