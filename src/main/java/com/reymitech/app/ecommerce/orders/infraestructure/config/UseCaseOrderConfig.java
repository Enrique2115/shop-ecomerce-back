package com.reymitech.app.ecommerce.orders.infraestructure.config;

import com.reymitech.app.ecommerce.client.domain.port.IClientRepositoryPort;
import com.reymitech.app.ecommerce.orders.application.usecase.ChangeOrderStatusUseCase;
import com.reymitech.app.ecommerce.orders.application.usecase.CreateOrderUseCase;
import com.reymitech.app.ecommerce.orders.application.usecase.FindAllOrderUseCase;
import com.reymitech.app.ecommerce.orders.application.usecase.FindByIdOrderUseCase;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderValidationService;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseOrderConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(IOrderRepositoryPort orderRepositoryPort, IProductRepositoryPort productRepositoryPort, IOrderValidationService orderValidationService) {
        return new CreateOrderUseCase(orderRepositoryPort, productRepositoryPort, orderValidationService);
    }

    @Bean
    public FindAllOrderUseCase findAllOrderUseCase(IOrderRepositoryPort orderRepositoryPort) {
        return new FindAllOrderUseCase(orderRepositoryPort);
    }

    @Bean
    public FindByIdOrderUseCase findByIdOrderUseCase(IOrderRepositoryPort orderRepositoryPort) {
        return new FindByIdOrderUseCase(orderRepositoryPort);
    }

    @Bean
    public ChangeOrderStatusUseCase changeOrderStatusUseCase(IOrderRepositoryPort orderRepositoryPort) {
        return new ChangeOrderStatusUseCase(orderRepositoryPort);
    }
}
