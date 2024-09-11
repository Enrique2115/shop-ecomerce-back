package com.reymitech.app.ecommerce.orders.domain.dtos;

import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import lombok.Data;

@Data
public class OrderDto {
    private String id;
    private String clientId;
    private double total;
    private StatusOrder status;
}
