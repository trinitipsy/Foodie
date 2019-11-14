package com.foodie.FoodSetGo.dto;

import com.foodie.FoodSetGo.model.Food;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CreateOrderRequest {
    List<Integer> id_food;
    private String deliveryAddress;

}
