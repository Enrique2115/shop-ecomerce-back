package com.reymitech.app.ecommerce.orders.application.usecase;

import com.reymitech.app.ecommerce.orders.domain.models.Order;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import com.reymitech.app.ecommerce.orders.infraestructure.Contants;
import com.reymitech.app.ecommerce.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindByIdOrderUseCase {

    private final IOrderRepositoryPort orderRepositoryPort;

    public Order findById(String id) {
        return orderRepositoryPort.findById(id).orElseThrow(() -> new NotFoundException(String.format(Contants.ORDER_NOT_FOUND, id)));
    }
}
