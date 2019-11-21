package com.foodie.FoodSetGo.repository;

import com.foodie.FoodSetGo.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Integer> {

    List<Food> findAllByActiveTrue();

    Optional<Food> findByActiveTrueAndId(Integer id);

}
