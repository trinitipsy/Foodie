package com.foodie.dto;

import lombok.Data;

@Data
public class AddRestaurantRequest {
    private String name;
    private String email;
    private String address;
    private String description;
}
