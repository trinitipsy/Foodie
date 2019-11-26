package com.foodie.service.impl;

import com.foodie.dto.SaveFoodRequest;
import com.foodie.dto.UpdateFoodRequest;
import com.foodie.exception.NotFoundException;
import com.foodie.model.Food;
import com.foodie.model.Restaurant;
import com.foodie.repository.FoodRepository;
import com.foodie.repository.RestaurantRepository;
import com.foodie.service.FoodService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Food> getAll() {
        return foodRepository.findAllByActiveTrue();
    }

    @Override
    public Food get(Integer id) {
        try {
            return foodRepository.findByActiveTrueAndId(id)
                    .orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Food update(Integer foodId, UpdateFoodRequest updateFoodRequest) {
        Food foodForUpdate = null;
        try {
            foodForUpdate = foodRepository.findById(foodId).orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        foodForUpdate.setName(updateFoodRequest.getName());
        foodForUpdate.setPrice(updateFoodRequest.getPrice());
        foodForUpdate.setDescription(updateFoodRequest.getDescription());

        return foodRepository.save(foodForUpdate);
    }

    @Override
    public Food delete(Integer foodId) {
        Food food = null;
        try {
            food = foodRepository.findById(foodId)
                    .orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        food.setActive(false);
        return foodRepository.save(food);
    }

    @Override
    public Food add(Integer restaurantId, SaveFoodRequest saveFoodRequest) {
        Restaurant restaurant = null;
        try {
            restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        Food food = new Food();
        food.setName(saveFoodRequest.getName());
        food.setPrice(saveFoodRequest.getPrice());
        food.setActive(true);
        food.setDescription(saveFoodRequest.getDescription());
        food.setRestaurant(restaurant);
        return foodRepository.save(food);
    }
}
