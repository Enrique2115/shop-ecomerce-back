package com.reymitech.app.ecommerce.client.application.usecase;

import com.reymitech.app.ecommerce.client.domain.models.Client;
import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllClientsUseCase {
    private final IClientRepositoryPort clientRepositoryPort;

    public List<Client> execute() {
        return clientRepositoryPort.findAllClients();
    }
}
