package com.foodie.FoodSetGo.repository;

import com.foodie.FoodSetGo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
