package com.foodie.service.impl;

import com.foodie.dto.AddRestaurantRequest;
import com.foodie.dto.RestaurantListResponse;
import com.foodie.exception.NotFoundException;
import com.foodie.model.Restaurant;
import com.foodie.repository.RestaurantRepository;
import com.foodie.service.RestaurantService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantListResponse> getAll() {
        final List<Restaurant> restaurants = restaurantRepository.findAllByActiveTrue();
        return restaurants.stream().map(RestaurantListResponse::new).collect(Collectors.toList());
    }

    @Override
    public Restaurant get(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                    .orElseThrow(NotFoundException::new);
        restaurant.getMenu().removeIf(f -> !f.getActive());
        return restaurant;
    }

    @Override
    public Restaurant delete(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
        restaurant.setActive(false);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Integer id, AddRestaurantRequest addRestaurantRequest) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
        restaurant.setName(addRestaurantRequest.getName());
        restaurant.setAddress(addRestaurantRequest.getAddress());
        restaurant.setEmail(addRestaurantRequest.getEmail());
        restaurant.setDescription(addRestaurantRequest.getDescription());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant add(AddRestaurantRequest addRestaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(addRestaurantRequest.getName());
        restaurant.setEmail(addRestaurantRequest.getEmail());
        restaurant.setAddress(addRestaurantRequest.getAddress());
        restaurant.setDescription(addRestaurantRequest.getDescription());
        restaurant.setActive(true);
        return restaurantRepository.save(restaurant);
    }
}
