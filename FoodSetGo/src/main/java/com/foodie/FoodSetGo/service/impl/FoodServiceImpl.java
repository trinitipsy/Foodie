package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.model.Restaurant;
import com.foodie.FoodSetGo.repository.FoodRepository;
import com.foodie.FoodSetGo.repository.RestaurantRepository;
import com.foodie.FoodSetGo.service.FoodService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food get(Integer id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public Food update(Integer foodId, UpdateFoodRequest updateFoodRequest) {
        Optional<Food> foodForUpdate = foodRepository.findById(foodId);
        if(!foodForUpdate.isPresent()) {
            throw new EntityNotFoundException();
        }
        foodForUpdate.get().setName(updateFoodRequest.getName());
        foodForUpdate.get().setPrice(updateFoodRequest.getPrice());
        foodForUpdate.get().setDescription(updateFoodRequest.getDescription());
        return foodRepository.save(foodForUpdate.get());
    }

    @Override
    public void delete(Integer restaurantId, Integer foodId) {
        Food food = foodRepository.findById(foodId).get();
        if(food.getRestaurant().getId().equals(restaurantId)) {
            foodRepository.deleteById(foodId);
        }
    }

    @Override
    public Food save(UpdateFoodRequest updateFoodRequest) {
        Restaurant restaurant = restaurantRepository.findById(updateFoodRequest.getRestaurantId()).get();
        Food food = new Food();
        food.setName(updateFoodRequest.getName());
        food.setPrice(updateFoodRequest.getPrice());
        food.setDescription(updateFoodRequest.getDescription());
        food.setRestaurant(restaurant);
        return foodRepository.save(food);
    }
}
