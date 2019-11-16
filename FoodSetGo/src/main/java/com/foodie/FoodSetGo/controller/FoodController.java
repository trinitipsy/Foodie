package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.constants.Cors;
import com.foodie.FoodSetGo.dto.UpdateFoodRequest;
import com.foodie.FoodSetGo.model.Food;
import com.foodie.FoodSetGo.service.FoodService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = Cors.origins)
public class FoodController {
    private final FoodService foodService;

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
    @DeleteMapping("/{restaurantId}/{foodId}")
    public void delete(@PathVariable Integer restaurantId, @PathVariable Integer foodId) {
        foodService.delete(restaurantId, foodId);
    }
}
