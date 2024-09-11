package com.reymitech.app.ecommerce.products.application.usecase;

import com.reymitech.app.ecommerce.products.domain.models.Product;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import com.reymitech.app.ecommerce.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindByIdUseCase {

    private final IProductRepositoryPort productRepositoryPort;

    public Product execute(String id){
        return productRepositoryPort.findById(id);
    }
}
