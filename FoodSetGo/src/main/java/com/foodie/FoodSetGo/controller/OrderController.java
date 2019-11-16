package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.constants.Cors;
import com.foodie.FoodSetGo.dto.CreateOrderRequest;
import com.foodie.FoodSetGo.model.Order;
import com.foodie.FoodSetGo.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = Cors.origins)
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody CreateOrderRequest createOrderRequest) {
        return ResponseEntity.ok(orderService.save(createOrderRequest));
    }
}
