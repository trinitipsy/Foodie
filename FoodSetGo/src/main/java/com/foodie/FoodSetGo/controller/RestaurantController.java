package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.constants.Cors;
import com.foodie.FoodSetGo.dto.GetRestaurantsResponse;
import com.foodie.FoodSetGo.dto.UpdateRestaurantRequest;
import com.foodie.FoodSetGo.model.Restaurant;
import com.foodie.FoodSetGo.service.RestaurantService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = Cors.origins)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<GetRestaurantsResponse>> getAll() {
        List<GetRestaurantsResponse> list = restaurantService.getAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(restaurantService.get(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody UpdateRestaurantRequest updateRestaurantRequest) {
        return ResponseEntity.ok(restaurantService.save(updateRestaurantRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable("id") Integer id, @RequestBody UpdateRestaurantRequest updateRestaurantRequest) {
        return ResponseEntity.ok(restaurantService.update(id, updateRestaurantRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restaurantService.delete(id);
    }
}
