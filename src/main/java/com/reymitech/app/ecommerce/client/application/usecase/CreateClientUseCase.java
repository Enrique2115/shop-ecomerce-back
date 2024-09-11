package com.reymitech.app.ecommerce.client.application.usecase;

import com.reymitech.app.ecommerce.client.domain.models.Client;
import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import com.reymitech.app.ecommerce.client.infraestructure.Contants;
import com.reymitech.app.ecommerce.client.presentation.request.CreateClientRequest;
import com.reymitech.app.ecommerce.utils.exceptions.GenericErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class CreateClientUseCase {

    private final IClientRepositoryPort clientRepositoryPort;

    public Client execute(CreateClientRequest clientRequest) {
        isExistClient(clientRequest.getDocument());

        return createClient(clientRequest);
    }

    private void isExistClient(String document) {
        clientRepositoryPort.findByDocument(document).ifPresent(
                client -> {
                    throw new GenericErrorResponse(String.format(Contants.CLIENT_EXIST, document), HttpStatus.CONFLICT);
                }
        );
    }

    private Client createClient(CreateClientRequest clientRequest) {
        Client client = Client.builder()
                .name(clientRequest.getName())
                .email(clientRequest.getEmail())
                .document(clientRequest.getDocument())
                .phone(clientRequest.getPhone())
                .build();

        return clientRepositoryPort.save(client);
    }
}
