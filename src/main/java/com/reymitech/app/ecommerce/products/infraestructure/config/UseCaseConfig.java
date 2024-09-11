package com.reymitech.app.ecommerce.products.infraestructure.config;

import com.reymitech.app.ecommerce.products.application.usecase.CreateProductUseCase;
import com.reymitech.app.ecommerce.products.application.usecase.FindAllProductsUseCase;
import com.reymitech.app.ecommerce.products.application.usecase.FindByIdUseCase;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import com.reymitech.app.ecommerce.products.domain.port.IProductValidationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(IProductRepositoryPort productRepositoryPort, IProductValidationService productValidationService) {
        return new CreateProductUseCase(productRepositoryPort, productValidationService);
    }

    @Bean
    public FindAllProductsUseCase findAllProductsUseCase(IProductRepositoryPort productRepositoryPort) {
        return new FindAllProductsUseCase(productRepositoryPort);
    }

    @Bean
    public FindByIdUseCase findByIdUseCase(IProductRepositoryPort productRepositoryPort) {
        return new FindByIdUseCase(productRepositoryPort);
    }
}
