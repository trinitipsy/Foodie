package com.foodie.service;

import com.foodie.dto.AddRestaurantRequest;
import com.foodie.dto.RestaurantListResponse;
import com.foodie.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<RestaurantListResponse> getAll();

    Restaurant get(final Integer id);

    Restaurant delete(final Integer id);

    Restaurant update(final Integer id, final AddRestaurantRequest addRestaurantRequest);

    Restaurant add(final AddRestaurantRequest addRestaurantRequest);
}
