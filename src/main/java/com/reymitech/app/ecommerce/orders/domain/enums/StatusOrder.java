package com.reymitech.app.ecommerce.orders.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusOrder {
    PENDING,
    PAID,
    SHIPPED,
    CANCELLED;

    @JsonCreator
    public static StatusOrder fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}
