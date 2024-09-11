package com.reymitech.app.ecommerce.client.presentation.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateClientRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Document is required")
    private String document;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;
}
