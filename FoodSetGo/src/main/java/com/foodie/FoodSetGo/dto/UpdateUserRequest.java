package com.foodie.FoodSetGo.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String surname;
    private String address;
}
