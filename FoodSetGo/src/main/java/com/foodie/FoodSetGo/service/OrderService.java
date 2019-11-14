package com.foodie.FoodSetGo.service;

import com.foodie.FoodSetGo.dto.CreateOrderRequest;
import com.foodie.FoodSetGo.model.Order;

public interface OrderService {
    Order save(CreateOrderRequest createOrderRequest);

}
