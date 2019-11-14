package com.foodie.FoodSetGo.repository;

import com.foodie.FoodSetGo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
