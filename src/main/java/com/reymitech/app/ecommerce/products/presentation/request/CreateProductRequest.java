package com.reymitech.app.ecommerce.products.presentation.request;

import com.reymitech.app.ecommerce.products.domain.enums.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateProductRequest {

    @NotBlank(message = "El nombre no debe estar vacío")
    private String productName;

    @NotBlank(message = "La descripcion no debe estar vacía")
    private String productDescription;

    @Positive(message = "El precio no puede ser negativo")
    private double productPrice;

    @Positive(message = "El stock no puede ser negativo")
    private int productStock;

    @NotBlank(message = "El brand no debe estar vacío")
    private String productBrand;

    @NotBlank(message = "La imagen no debe estar vacía")
    private String productImage;

    @NotBlank(message = "El sku no debe estar vacío")
    private String productSku;

    @NotNull(message = "La categoria no puede ser nula")
    private ProductCategory productCategory;
}
