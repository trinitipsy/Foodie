package com.foodie.FoodSetGo.dto;

import lombok.Data;

@Data
public class UpdateFoodRequest {
    private String name;
    private Double price;
    private String description;
    private Integer restaurant_id;
}
