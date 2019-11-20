package com.foodie.FoodSetGo.dto;

import lombok.Data;

@Data
public class SaveFoodRequest {
    private String name;
    private Double price;
    private String description;
}
