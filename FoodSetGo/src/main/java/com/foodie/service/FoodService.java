package com.foodie.service;

import com.foodie.dto.SaveFoodRequest;
import com.foodie.dto.UpdateFoodRequest;
import com.foodie.model.Food;

import java.util.List;
import java.util.Map;

public interface FoodService {
    List<Food> getAll();

    Food get(final Integer id);

    Map<String, Integer> count();

    Food update(final Integer foodId, final UpdateFoodRequest updateFoodRequest);

    Food delete(final Integer foodId);

    Food add(final Integer restaurantId, final SaveFoodRequest saveFoodRequest);
}
