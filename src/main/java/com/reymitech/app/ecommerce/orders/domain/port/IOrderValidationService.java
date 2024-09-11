package com.reymitech.app.ecommerce.orders.domain.port;

import com.reymitech.app.ecommerce.orders.domain.dtos.ProductDto;
import com.reymitech.app.ecommerce.orders.presentation.request.CreateOrderRequest;

import java.util.List;

public interface IOrderValidationService {
    boolean isValidTotal(CreateOrderRequest createOrderRequest);

    List<String> existStockProducts(CreateOrderRequest createOrderRequest, List<ProductDto> products);
}
