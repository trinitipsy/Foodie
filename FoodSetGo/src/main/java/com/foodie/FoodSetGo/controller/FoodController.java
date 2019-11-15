package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.service.FoodService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getAll() {
        return ResponseEntity.ok(foodService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Food> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(foodService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> update(@PathVariable("id") Integer id, @RequestBody UpdateFoodRequest updateFoodRequest) {
        return ResponseEntity.ok(foodService.update(id, updateFoodRequest));
    }
    @PostMapping
    public ResponseEntity<Food> save(@RequestBody UpdateFoodRequest updateFoodRequest) {
        return ResponseEntity.ok(foodService.save(updateFoodRequest));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer restaurant_id, @RequestParam Integer food_id) {
        foodService.delete(restaurant_id, food_id);
    }
}
