package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.UpdateRestaurantRequest;
import com.foodie.FoodSetGo.model.Restaurant;
import com.foodie.FoodSetGo.service.RestaurantService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll() {
        return ResponseEntity.ok(restaurantService.getAll());
    }

    @GetMapping("/one")
    public ResponseEntity<Restaurant> get(Integer id) {
        return ResponseEntity.ok(restaurantService.get(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody UpdateRestaurantRequest updateRestaurantRequest) {
        return ResponseEntity.ok(restaurantService.save(updateRestaurantRequest));
    }

    @PutMapping
    public ResponseEntity<Restaurant> update(@RequestParam Integer id, @RequestBody UpdateRestaurantRequest updateRestaurantRequest) {
        return ResponseEntity.ok(restaurantService.update(id, updateRestaurantRequest));
    }

    @DeleteMapping
    public void delete(Integer id) {
        restaurantService.delete(id);
    }
}
