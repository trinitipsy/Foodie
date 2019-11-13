package com.foodie.FoodSetGo.repository;

import com.foodie.FoodSetGo.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodRepository extends JpaRepository<Food, Integer> {
}
