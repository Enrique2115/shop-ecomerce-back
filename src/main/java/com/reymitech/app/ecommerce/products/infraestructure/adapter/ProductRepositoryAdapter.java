package com.reymitech.app.ecommerce.products.infraestructure.adapter;

import com.reymitech.app.ecommerce.products.domain.enums.Active;
import com.reymitech.app.ecommerce.products.domain.models.Product;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import com.reymitech.app.ecommerce.products.infraestructure.Contants;
import com.reymitech.app.ecommerce.products.infraestructure.repository.JpaProductRepository;
import com.reymitech.app.ecommerce.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements IProductRepositoryPort {
    private final JpaProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllByActive(Active.ACTIVE);
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return Optional.ofNullable(productRepository.findBySku(sku));
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow( () -> new NotFoundException(String.format(Contants.PRODUCT_NOT_FOUND, id)));
    }

    @Override
    public List<Product> findAllByNameContaining(String query) {
        return productRepository.findAllByNameContaining(query);
    }
}
