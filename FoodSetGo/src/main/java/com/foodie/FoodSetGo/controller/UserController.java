package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.UpdateUserRequest;
import com.foodie.FoodSetGo.model.User;
import com.foodie.FoodSetGo.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.get(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody UpdateUserRequest user) {
        return  ResponseEntity.ok(userService.update(id, user));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody UpdateUserRequest user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
