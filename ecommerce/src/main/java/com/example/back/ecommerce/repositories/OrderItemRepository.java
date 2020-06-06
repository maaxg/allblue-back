package com.example.back.ecommerce.repositories;

import com.example.back.ecommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
