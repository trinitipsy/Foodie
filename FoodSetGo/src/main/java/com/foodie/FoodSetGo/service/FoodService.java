package com.foodie.FoodSetGo.service;

import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAll();
    Food get(Integer id);
    Food update(Integer food_id, UpdateFoodRequest updateFoodRequest);
    void delete(Integer restaurant_id, Integer food_id);
    Food save(UpdateFoodRequest updateFoodRequest);
}
