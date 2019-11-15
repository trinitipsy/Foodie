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
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Food>> getAll() {
        return ResponseEntity.ok(foodService.getAll());
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
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
    @DeleteMapping("/{restaurant_id}/{food_id}")
    public void delete(@PathVariable("restaurant_id") Integer restaurant_id, @PathVariable("food_id") Integer food_id) {
        foodService.delete(restaurant_id, food_id);
    }
}
