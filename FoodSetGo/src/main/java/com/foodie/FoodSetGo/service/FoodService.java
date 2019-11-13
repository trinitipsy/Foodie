package com.foodie.FoodSetGo.service;

import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAll();
    Food get(Integer id);
    void delete(Integer id);
    Food update(Integer id, UpdateFoodRequest updateFoodRequest);
    Food save(UpdateFoodRequest updateFoodRequest);
    void deleteFood(Integer restaurant_id, Integer food_id);
    Food saveFood(Integer restaurant_id, UpdateFoodRequest updateFoodRequest);
}
