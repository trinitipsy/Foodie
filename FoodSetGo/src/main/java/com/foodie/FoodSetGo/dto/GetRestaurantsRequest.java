package com.foodie.FoodSetGo.dto;

import lombok.Data;

@Data
public class GetRestaurantsRequest {
    private String name;
    private String email;
    private String address;
    private String description;
}
