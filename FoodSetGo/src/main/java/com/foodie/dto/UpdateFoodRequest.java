package com.foodie.dto;
import lombok.Data;

@Data
public class UpdateFoodRequest {
    private String name;
    private Double price;
    private String description;
}
