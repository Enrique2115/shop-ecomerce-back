package com.reymitech.app.ecommerce.products.application.usecase;

import com.reymitech.app.ecommerce.products.domain.models.Product;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllProductsUseCase {
    private final IProductRepositoryPort productRepositoryPort;

    public List<Product> execute(){
        return productRepositoryPort.findAllProducts();
    }
}
