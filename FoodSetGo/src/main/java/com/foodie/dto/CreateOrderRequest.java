package com.foodie.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    List<Integer> foodIds;

}
