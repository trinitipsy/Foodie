package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.CreateOrderRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.model.Order;
import com.foodie.FoodSetGo.repository.FoodRepository;
import com.foodie.FoodSetGo.repository.OrderRepository;
import com.foodie.FoodSetGo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FoodRepository foodRepository;

    @Override
    public Order save(CreateOrderRequest createOrderRequest) {
        List<Food> food = foodRepository.findAllById(createOrderRequest.getId_food());

        Order order = new Order();
        order.setFood(food);
        Double totalPrice = food.stream().map((f) -> {
                    int amount = Collections.frequency(createOrderRequest.getId_food(), f.getId());
                    return f.getPrice() * amount;
                }
        ).reduce((double) 0,Double::sum);
        order.setTotalPrice(totalPrice);
        order.setDeliveryAddress(createOrderRequest.getDeliveryAddress());
        return orderRepository.save(order);
    }
}
