package com.foodie.service;

import com.foodie.dto.CreateOrderRequest;
import com.foodie.model.Order;

public interface OrderService {
    Order add(final String address, final CreateOrderRequest createOrderRequest);

}
