package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.service.FoodService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getAll() {
        return ResponseEntity.ok(foodService.getAll());
    }
    @GetMapping("/one")
    public ResponseEntity<Food> get(@RequestParam Integer id) {
        return ResponseEntity.ok(foodService.get(id));
    }

    @PutMapping
    public ResponseEntity<Food> update(@RequestParam Integer id, @RequestBody UpdateFoodRequest updateFoodRequest) {
        return ResponseEntity.ok(foodService.update(id, updateFoodRequest));
    }
    @PostMapping
    public ResponseEntity<Food> save(@RequestBody UpdateFoodRequest updateFoodRequest) {
        return ResponseEntity.ok(foodService.save(updateFoodRequest));
    }
    @DeleteMapping
    public void delete(@RequestParam Integer restaurant_id, @RequestParam Integer food_id) {
        foodService.delete(restaurant_id, food_id);
    }
}
