package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.CreateOrderRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.model.Order;
import com.foodie.FoodSetGo.repository.FoodRepository;
import com.foodie.FoodSetGo.repository.OrderRepository;
import com.foodie.FoodSetGo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;

    @Override
    public Order save(CreateOrderRequest createOrderRequest) {
        List<Integer> foodIds = createOrderRequest.getFoodIds();
        List<Food> food = foodRepository.findAllById(foodIds);

        Order order = new Order();
        order.setFood(food);

        ToDoubleFunction<Food> toPrice = (f) -> f.getPrice() * Collections.frequency(foodIds, f.getId());
        Double totalPrice = food.stream().mapToDouble(toPrice).sum();
        order.setTotalPrice(totalPrice);
        order.setDeliveryAddress(createOrderRequest.getDeliveryAddress());

        return orderRepository.save(order);
    }
}
