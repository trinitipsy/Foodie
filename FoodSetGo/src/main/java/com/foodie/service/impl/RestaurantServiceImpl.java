package com.foodie.service.impl;

import com.foodie.dto.RestaurantListResponse;
import com.foodie.dto.AddRestaurantRequest;
import com.foodie.exception.NotFoundException;
import com.foodie.model.Restaurant;
import com.foodie.repository.RestaurantRepository;
import com.foodie.service.RestaurantService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantListResponse> getAll() {
        final List<Restaurant> restaurants = restaurantRepository.findAllByActiveTrue();
        final List<RestaurantListResponse> restaurantListResponse = new ArrayList<>();

        restaurants.stream().map(r -> )

        //TODO Java 8+
        for (Restaurant r : restaurants) {
            RestaurantListResponse req = new RestaurantListResponse();
            req.setId(r.getId());
            req.setName(r.getName());
            req.setAddress(r.getAddress());
            req.setEmail(r.getAddress());
            req.setDescription(r.getDescription());
            restaurantListResponse.add(req);
        }
        return restaurantListResponse;
    }

    @Override
    public Restaurant get(Integer id) {
        Restaurant restaurant = null;
        try {
            restaurant = restaurantRepository.findById(id)
                    .orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        restaurant.getMenu().removeIf(f -> !f.getActive());
        return restaurant;
    }

    @Override
    public Restaurant delete(Integer id) {
        Restaurant restaurant = null;
        try {
            restaurant = restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        restaurant.setActive(false);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Integer id, AddRestaurantRequest addRestaurantRequest) {
        Restaurant restaurant = null;
        try {
            restaurant = restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
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
