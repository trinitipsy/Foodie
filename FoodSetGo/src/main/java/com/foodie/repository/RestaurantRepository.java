package com.foodie.repository;

import com.foodie.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findAllByActiveTrue();
    Integer countRestaurantsByActiveTrue();
}
