package com.reymitech.app.ecommerce.client.domain.port;

import com.reymitech.app.ecommerce.client.domain.models.Client;

import java.util.List;
import java.util.Optional;

public interface IClientRepositoryPort {
    Client save(Client client);

    Client findById(String id);

    List<Client> findAllClients();

    Optional<Client> findByDocument(String document);
}
