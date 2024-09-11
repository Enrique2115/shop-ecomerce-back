package com.reymitech.app.ecommerce.client.infraestructure.adapter;

import com.reymitech.app.ecommerce.client.domain.models.Client;
import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import com.reymitech.app.ecommerce.client.infraestructure.Contants;
import com.reymitech.app.ecommerce.client.infraestructure.repository.JpaClientRepository;
import com.reymitech.app.ecommerce.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements IClientRepositoryPort {

    private final JpaClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format(Contants.CLIENT_NOT_FOUND, id)));
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findByDocument(String document) {
        return Optional.ofNullable(clientRepository.findByDocument(document));
    }
}
