package com.foodie.FoodSetGo.service;

import com.foodie.FoodSetGo.dto.SaveFoodRequest;
import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAll();
    Food get(Integer id);
    Food update(Integer foodId, UpdateFoodRequest updateFoodRequest);
    void delete(Integer foodId);
    Food save(Integer restaurantId, SaveFoodRequest saveFoodRequest);
}
