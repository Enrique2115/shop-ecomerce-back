package com.reymitech.app.ecommerce.orders.domain.models;

import com.reymitech.app.ecommerce.orders.presentation.request.ProductOrderRequest;
import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    private String clientId;

    private List<ProductOrderRequest> products;

    private double total;

    private StatusOrder status;
}
