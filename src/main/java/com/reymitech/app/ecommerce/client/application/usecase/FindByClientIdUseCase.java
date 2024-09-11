package com.reymitech.app.ecommerce.client.application.usecase;

import com.reymitech.app.ecommerce.client.domain.models.Client;
import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindByClientIdUseCase {
    private final IClientRepositoryPort clientRepositoryPort;

    public Client execute(String id) {
        return clientRepositoryPort.findById(id);
    }
}
