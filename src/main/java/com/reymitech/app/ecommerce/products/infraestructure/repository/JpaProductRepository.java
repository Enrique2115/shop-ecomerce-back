package com.reymitech.app.ecommerce.products.infraestructure.repository;

import com.reymitech.app.ecommerce.products.domain.enums.Active;
import com.reymitech.app.ecommerce.products.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByActive(Active active);

    Product findBySku(String sku);
}
