package com.reymitech.app.ecommerce.orders.infraestructure.adapter;

import com.reymitech.app.ecommerce.orders.domain.enums.StatusOrder;
import com.reymitech.app.ecommerce.orders.domain.models.Order;
import com.reymitech.app.ecommerce.orders.domain.port.IOrderRepositoryPort;
import com.reymitech.app.ecommerce.orders.infraestructure.repository.MongoOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements IOrderRepositoryPort {
    private final MongoOrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order).subscribe(x -> log.info("Order saved successfully"));
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll().collectList().block();
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orderRepository.findById(id).block());
    }

    @Override
    public void changeOrderStatus(String id, StatusOrder status) {
        Order order = orderRepository.findById(id).block();
        assert order != null;
        order.setStatus(status);

        orderRepository.save(order).subscribe(x -> log.info("Order status changed successfully"));
    }
}
