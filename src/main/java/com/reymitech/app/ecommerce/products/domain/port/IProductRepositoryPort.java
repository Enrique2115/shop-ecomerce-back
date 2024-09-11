package com.reymitech.app.ecommerce.products.domain.port;

import com.reymitech.app.ecommerce.products.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepositoryPort {

    Product save(Product product);

    List<Product> findAllProducts();

    Optional<Product> findBySku(String sku);

    Product findById(String id);
}
