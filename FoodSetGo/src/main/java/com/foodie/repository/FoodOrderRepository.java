package com.foodie.repository;

import com.foodie.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<OrderItem, Integer> {
}
