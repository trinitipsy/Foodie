package com.foodie.service.impl;

import com.foodie.dto.CreateOrderRequest;
import com.foodie.model.Food;
import com.foodie.model.Order;
import com.foodie.repository.FoodRepository;
import com.foodie.repository.OrderRepository;
import com.foodie.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;

    @Override
    public Order add(String address, CreateOrderRequest createOrderRequest) {
        List<Integer> foodIds = createOrderRequest.getFoodIds();
        List<Food> food = foodRepository.findAllById(foodIds);
        Order order = new Order();
        order.setFood(food);

        ToDoubleFunction<Food> toPrice = (f) -> f.getPrice() * Collections.frequency(foodIds, f.getId());
        Double totalPrice = food.stream().mapToDouble(toPrice).sum();
        order.setTotalPrice(totalPrice);
        order.setDeliveryAddress(address);

        return orderRepository.save(order);
    }
}
