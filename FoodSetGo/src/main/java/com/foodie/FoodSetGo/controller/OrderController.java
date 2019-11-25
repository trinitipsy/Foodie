package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.constants.Cors;
import com.foodie.FoodSetGo.dto.CreateOrderRequest;
import com.foodie.FoodSetGo.model.Order;
import com.foodie.FoodSetGo.repository.UserRepository;
import com.foodie.FoodSetGo.service.OrderService;
import com.foodie.FoodSetGo.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = Cors.origins)
public class OrderController {
    private final OrderService orderService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Order> save(Authentication authentication, @RequestBody CreateOrderRequest createOrderRequest) {
        String email = authentication.getName();
        String address = userRepository.findByEmail(email).get().getAddress();
        return ResponseEntity.ok(orderService.save(address, createOrderRequest));
    }
}
