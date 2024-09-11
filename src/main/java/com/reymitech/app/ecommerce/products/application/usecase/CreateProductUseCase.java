package com.reymitech.app.ecommerce.products.application.usecase;

import com.reymitech.app.ecommerce.products.domain.enums.Active;
import com.reymitech.app.ecommerce.products.domain.models.Product;
import com.reymitech.app.ecommerce.products.domain.port.IProductRepositoryPort;
import com.reymitech.app.ecommerce.products.domain.port.IProductValidationService;
import com.reymitech.app.ecommerce.products.infraestructure.Contants;
import com.reymitech.app.ecommerce.products.presentation.request.CreateProductRequest;
import com.reymitech.app.ecommerce.utils.exceptions.GenericErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class CreateProductUseCase {

    private final IProductRepositoryPort productRepositoryPort;
    private final IProductValidationService productValidationService;

    public Product execute(CreateProductRequest createProductRequest) {
        isExistProduct(createProductRequest.getProductSku());

        if (!productValidationService.isValid(createProductRequest.getProductName())) {
            throw new GenericErrorResponse(Contants.PRODUCT_NOT_VALID_NAME, HttpStatus.BAD_REQUEST);
        } else if (!productValidationService.isValidStock(createProductRequest.getProductStock())) {
            throw new GenericErrorResponse(Contants.PRODUCT_NOT_VALID_STOCK, HttpStatus.BAD_REQUEST);
        }

        return createProduct(createProductRequest);
    }

    private Product createProduct(CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .name(createProductRequest.getProductName())
                .price(createProductRequest.getProductPrice())
                .description(createProductRequest.getProductDescription())
                .image(createProductRequest.getProductImage())
                .sku(createProductRequest.getProductSku())
                .productCategory(createProductRequest.getProductCategory())
                .active(Active.ACTIVE)
                .stock(createProductRequest.getProductStock())
                .brand(createProductRequest.getProductBrand())
                .build();

        return productRepositoryPort.save(product);
    }

    private void isExistProduct(String productSku) {
        productRepositoryPort.findBySku(productSku).ifPresent(
                product -> {
                    throw new GenericErrorResponse(String.format(Contants.PRODUCT_EXIST, productSku), HttpStatus.CONFLICT);
                }
        );
    }
}
