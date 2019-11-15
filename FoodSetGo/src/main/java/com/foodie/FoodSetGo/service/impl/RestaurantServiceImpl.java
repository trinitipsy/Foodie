package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.GetRestaurantsRequest;
import com.foodie.FoodSetGo.dto.UpdateRestaurantRequest;
import com.foodie.FoodSetGo.model.Restaurant;
import com.foodie.FoodSetGo.repository.RestaurantRepository;
import com.foodie.FoodSetGo.service.RestaurantService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<GetRestaurantsRequest> getAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<GetRestaurantsRequest> getRestaurantsRequests = new ArrayList<>();
        for (Restaurant r: restaurants
             ) {
            GetRestaurantsRequest req = new GetRestaurantsRequest();
            req.setName(r.getName());
            req.setAddress(r.getAddress());
            req.setEmail(r.getAddress());
            req.setDescription(r.getDescription());
            getRestaurantsRequests.add(req);
        }
        return getRestaurantsRequests;
    }

    @Override
    public Restaurant get(Integer id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant update(Integer id, UpdateRestaurantRequest updateRestaurantRequest) {
        Restaurant restaurant = restaurantRepository.findById(id).get();
        restaurant.setName(updateRestaurantRequest.getName());
        restaurant.setAddress(updateRestaurantRequest.getAddress());
        restaurant.setEmail(updateRestaurantRequest.getEmail());
        restaurant.setDescription(updateRestaurantRequest.getDescription());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant save(UpdateRestaurantRequest updateRestaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(updateRestaurantRequest.getName());
        restaurant.setEmail(updateRestaurantRequest.getEmail());
        restaurant.setAddress(updateRestaurantRequest.getAddress());
        restaurant.setDescription(updateRestaurantRequest.getDescription());
        return restaurantRepository.save(restaurant);
    }
}
