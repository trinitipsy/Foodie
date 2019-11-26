package com.foodie.dto;

import lombok.Data;

@Data
public class SaveFoodRequest {
    private String name;
    private Double price;
    private String description;
}
