package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.GetRestaurantsRequest;
import com.foodie.FoodSetGo.dto.UpdateRestaurantRequest;
import com.foodie.FoodSetGo.model.Restaurant;
import com.foodie.FoodSetGo.service.RestaurantService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Data
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<GetRestaurantsRequest>> getAll() {
        List<GetRestaurantsRequest> list = restaurantService.getAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
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
