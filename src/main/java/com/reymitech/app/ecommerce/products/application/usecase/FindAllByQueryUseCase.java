package com.reymitech.app.ecommerce.products.application.usecase;

import com.reymitech.app.ecommerce.products.domain.models.Product;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllByQueryUseCase {

    private final IProductRepositoryPort productRepositoryPort;

    public List<Product> execute(String query) {
        return productRepositoryPort.findAllByNameContaining(query);
    }
}
