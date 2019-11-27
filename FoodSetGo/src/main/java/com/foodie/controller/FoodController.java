package com.foodie.controller;

import com.foodie.constants.Cors;
import com.foodie.dto.SaveFoodRequest;
import com.foodie.dto.UpdateFoodRequest;
import com.foodie.model.Food;
import com.foodie.service.FoodService;
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
    public ResponseEntity<Food> get(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(foodService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> update(@PathVariable("id") final Integer id, @RequestBody final UpdateFoodRequest updateFoodRequest) {
        return ResponseEntity.ok(foodService.update(id, updateFoodRequest));
    }
    @PostMapping("/{restaurantId}")
    public ResponseEntity<Food> save(@PathVariable("restaurantId") final Integer restaurantId, @RequestBody final SaveFoodRequest saveFoodRequest) {
        return ResponseEntity.ok(foodService.add(restaurantId, saveFoodRequest));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Integer id) { foodService.delete(id);
    }
}
