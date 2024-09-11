package com.reymitech.app.ecommerce.orders.domain.dtos;

import com.reymitech.app.ecommerce.orders.presentation.request.ProductOrderRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDetailsDto extends OrderDto{
    private List<ProductOrderRequest> products;
}
