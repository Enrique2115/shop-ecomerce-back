package com.reymitech.app.ecommerce.products.domain.dtos;

import com.reymitech.app.ecommerce.products.domain.enums.Active;
import com.reymitech.app.ecommerce.products.domain.enums.ProductCategory;
import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String name;
    private double price;
    private String description;
    private String image;
    private ProductCategory productCategory;
    private int stock;
    private Active active;
    private String brand;
}
