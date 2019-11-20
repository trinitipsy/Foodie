package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.SaveFoodRequest;
import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.exception.NotFoundException;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.model.Restaurant;
import com.foodie.FoodSetGo.repository.FoodRepository;
import com.foodie.FoodSetGo.repository.RestaurantRepository;
import com.foodie.FoodSetGo.service.FoodService;
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
        return foodRepository.findAll();
    }

    @Override
    public Food get(Integer id) {
        return foodRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Food update(Integer foodId, UpdateFoodRequest updateFoodRequest) {
        Food foodForUpdate = foodRepository.findById(foodId).orElseThrow(NotFoundException::new);

        foodForUpdate.setName(updateFoodRequest.getName());
        foodForUpdate.setPrice(updateFoodRequest.getPrice());
        foodForUpdate.setDescription(updateFoodRequest.getDescription());

        return foodRepository.save(foodForUpdate);
    }

    @Override
    public void delete( Integer foodId) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(NotFoundException::new);
        foodRepository.delete(food);
    }

    @Override
    public Food save(Integer restaurantId, SaveFoodRequest saveFoodRequest) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(NotFoundException::new);
        Food food = new Food();
        food.setName(saveFoodRequest.getName());
        food.setPrice(saveFoodRequest.getPrice());
        food.setDescription(saveFoodRequest.getDescription());
        food.setRestaurant(restaurant);
        return foodRepository.save(food);
    }
}
