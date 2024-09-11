package com.reymitech.app.ecommerce.orders.domain.port;

import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import com.reymitech.app.ecommerce.orders.domain.models.Order;

import java.util.List;

public interface IOrderRepositoryPort {
    void save(Order order);

    List<Order> findAllOrders();

    Order findById(String id);

    void changeOrderStatus(String id, StatusOrder status);
}
