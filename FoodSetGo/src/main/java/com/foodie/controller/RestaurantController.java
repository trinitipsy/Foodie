package com.foodie.controller;

import com.foodie.constants.Cors;
import com.foodie.dto.AddRestaurantRequest;
import com.foodie.dto.RestaurantListResponse;
import com.foodie.model.Restaurant;
import com.foodie.service.RestaurantService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = Cors.origins)
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantListResponse>> getAll() {
        return ResponseEntity.ok(restaurantService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(restaurantService.get(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> add(@RequestBody AddRestaurantRequest addRestaurantRequest) {
        return ResponseEntity.ok(restaurantService.add(addRestaurantRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable("id") Integer id, @RequestBody AddRestaurantRequest addRestaurantRequest) {
        return ResponseEntity.ok(restaurantService.update(id, addRestaurantRequest));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restaurantService.delete(id);
    }
}
