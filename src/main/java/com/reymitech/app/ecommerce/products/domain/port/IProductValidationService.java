package com.reymitech.app.ecommerce.products.domain.port;

public interface IProductValidationService {

    boolean isValid(String productName);

    boolean isValidStock(int stock);

}
