package com.reymitech.app.ecommerce.orders.presentation.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    @NotBlank(message = "Client id is required")
    private String clientId;

    @NotEmpty(message = "Product List is required")
    @NotNull(message = "Product List cannot be null")
    @Valid
    private List<ProductOrderRequest> products;

    @Positive(message = "El total no puede ser negativo")
    private double total;
}
