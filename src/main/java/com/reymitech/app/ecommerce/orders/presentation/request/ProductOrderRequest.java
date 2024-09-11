package com.reymitech.app.ecommerce.orders.presentation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductOrderRequest {
    @NotBlank(message = "Product id is required")
    private String id;
    @NotBlank(message = "Product name is required")
    private String name;
    @Positive(message = "El precio no puede ser negativo")
    private double price;
    @Positive(message = "La cantidad no puede ser negativa")
    private int quantity;
}
