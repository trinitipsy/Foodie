package com.foodie.dto;

import lombok.Data;

@Data
public class RestaurantListResponse {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String description;
}
