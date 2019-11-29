package com.foodie.service.impl;

import com.foodie.dto.CreateOrderRequest;
import com.foodie.model.Food;
import com.foodie.model.Order;
import com.foodie.model.OrderItem;
import com.foodie.repository.FoodRepository;
import com.foodie.repository.OrderItemRepository;
import com.foodie.repository.OrderRepository;
import com.foodie.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        List<OrderItem> orderItems1 = food.stream().map(f -> new OrderItem(f, Collections.frequency(foodIds, f.getId()), order, f.getPrice())).collect(Collectors.toList());;
        Double totalPrice1 = orderItems1.stream().mapToDouble(foodItem -> foodItem.getFood().getPrice() * foodItem.getAmount()).sum();

        order.setOrderItem(orderItems1);
        order.setTotalPrice(totalPrice1);
        order.setDeliveryAddress(address);

        return orderRepository.save(order);
    }
}
