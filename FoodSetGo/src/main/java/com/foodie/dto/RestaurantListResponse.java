package com.foodie.dto;

import com.foodie.model.Restaurant;
import lombok.Data;

@Data
public class RestaurantListResponse {
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String description;

    public RestaurantListResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.email = restaurant.getEmail();
        this.address = restaurant.getAddress();
        this.description = restaurant.getDescription();
    }
}
