package com.reymitech.app.ecommerce.products.application.service;

import com.reymitech.app.ecommerce.products.domain.port.IProductValidationService;
import org.springframework.stereotype.Service;

@Service
public class ProductValidationService implements IProductValidationService {
    @Override
    public boolean isValid(String productName) {
        return productName != null && !productName.isEmpty();
    }

    @Override
    public boolean isValidStock(int stock) {
        return stock > 0;
    }
}
