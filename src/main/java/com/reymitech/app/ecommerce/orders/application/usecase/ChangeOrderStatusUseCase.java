package com.reymitech.app.ecommerce.orders.application.usecase;

import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangeOrderStatusUseCase {
    private final IOrderRepositoryPort orderRepositoryPort;

    public void execute(String id, StatusOrder status) {
        orderRepositoryPort.changeOrderStatus(id, status);
    }
}
