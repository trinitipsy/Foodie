package com.foodie.FoodSetGo.service;

import com.foodie.FoodSetGo.dto.GetRestaurantsResponse;
import com.foodie.FoodSetGo.dto.UpdateRestaurantRequest;
import com.foodie.FoodSetGo.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<GetRestaurantsResponse> getAll();
    Restaurant get(Integer id);
    void delete(Integer id);
    Restaurant update(Integer id, UpdateRestaurantRequest updateRestaurantRequest);
    Restaurant save(UpdateRestaurantRequest updateRestaurantRequest);
}
