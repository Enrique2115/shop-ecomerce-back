package com.reymitech.app.ecommerce.client.infraestructure.config;

import com.reymitech.app.ecommerce.client.application.usecase.CreateClientUseCase;
import com.reymitech.app.ecommerce.client.application.usecase.FindAllClientsUseCase;
import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import com.reymitech.app.ecommerce.client.application.usecase.FindByClientIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientUseCaseConfig {

    @Bean
    public CreateClientUseCase createClientUseCase(IClientRepositoryPort clientRepositoryPort) {
        return new CreateClientUseCase(clientRepositoryPort);
    }

    @Bean
    public FindAllClientsUseCase findAllClientsUseCase(IClientRepositoryPort clientRepositoryPort) {
        return new FindAllClientsUseCase(clientRepositoryPort);
    }

    @Bean
    public FindByClientIdUseCase findByClientIdUseCase(IClientRepositoryPort clientRepositoryPort) {
        return new FindByClientIdUseCase(clientRepositoryPort);
    }
}
