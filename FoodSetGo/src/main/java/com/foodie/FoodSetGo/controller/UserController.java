package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.constants.Cors;
import com.foodie.FoodSetGo.dto.LoginRequest;
import com.foodie.FoodSetGo.dto.UpdateUserRequest;
import com.foodie.FoodSetGo.model.User;
import com.foodie.FoodSetGo.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = Cors.origins)
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping
    public ResponseEntity<User> update(Authentication authentication, @RequestBody UpdateUserRequest user) {
        return ResponseEntity.ok(userService.update(authentication.getName(), user));
    }

    @DeleteMapping
    public void delete(Authentication authentication) {

        userService.delete(authentication.getName());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UpdateUserRequest user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody LoginRequest loginRequest) {
        String token = userService.logIn(loginRequest.getUsername(), loginRequest.getPassword());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

}

