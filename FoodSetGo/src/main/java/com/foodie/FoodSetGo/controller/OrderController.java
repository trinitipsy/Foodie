package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.CreateOrderRequest;
import com.foodie.FoodSetGo.model.Order;
import com.foodie.FoodSetGo.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody CreateOrderRequest createOrderRequest) {
        return ResponseEntity.ok(orderService.save(createOrderRequest));
    }
}
