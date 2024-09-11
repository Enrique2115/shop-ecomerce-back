package com.reymitech.app.ecommerce.products.domain.models;

import com.reymitech.app.ecommerce.products.domain.enums.Active;
import com.reymitech.app.ecommerce.utils.entity.BaseEntity;
import com.reymitech.app.ecommerce.products.domain.enums.ProductCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "sku", nullable = false)
    private String sku;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category", nullable = false)
    private ProductCategory productCategory;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "active", nullable = false)
    private Active active;

    @Column(name = "brand", nullable = false)
    private String brand;

}
