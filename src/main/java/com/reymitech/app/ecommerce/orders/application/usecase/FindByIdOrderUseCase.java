package com.reymitech.app.ecommerce.orders.application.usecase;

import com.reymitech.app.ecommerce.orders.domain.models.Order;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindByIdOrderUseCase {

    private final IOrderRepositoryPort orderRepositoryPort;

    public Order findById(String id) {
        return orderRepositoryPort.findById(id);
    }
}
