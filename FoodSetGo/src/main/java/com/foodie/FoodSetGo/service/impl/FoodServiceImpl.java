package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.repository.FoodRepository;
import com.foodie.FoodSetGo.service.FoodService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;
    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food get(Integer id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        foodRepository.deleteById(id);
    }

    @Override
    public Food update(Integer id, UpdateFoodRequest updateFoodRequest) {
        Optional<Food> foodForUpdate = foodRepository.findById(id);
        if(!foodForUpdate.isPresent()) {
            throw new EntityNotFoundException();
        }
        foodForUpdate.get().setName(updateFoodRequest.getName());
        foodForUpdate.get().setPrice(updateFoodRequest.getPrice());
        foodForUpdate.get().setDescription(updateFoodRequest.getDescription());
        return foodRepository.save(foodForUpdate.get());
    }

    @Override
    public Food save(UpdateFoodRequest updateFoodRequest) {
        Food food = new Food();
        food.setName(updateFoodRequest.getName());
        food.setPrice(updateFoodRequest.getPrice());
        food.setDescription(updateFoodRequest.getDescription());
        return foodRepository.save(food);
    }
}
