package com.reymitech.app.ecommerce.orders.infraestructure.repository;

import com.reymitech.app.ecommerce.orders.domain.models.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoOrderRepository extends ReactiveMongoRepository<Order, String> {
}
