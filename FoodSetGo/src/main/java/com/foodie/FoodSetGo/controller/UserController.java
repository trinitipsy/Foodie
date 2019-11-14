package com.foodie.FoodSetGo.controller;

import com.foodie.FoodSetGo.dto.UpdateUserRequest;
import com.foodie.FoodSetGo.model.User;
import com.foodie.FoodSetGo.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/one")
    public ResponseEntity<User> get(Integer id) {
        return ResponseEntity.ok(userService.get(id));
    }
    @PutMapping("/put")
    public ResponseEntity<User> update(@RequestParam Integer id, @RequestBody UpdateUserRequest user) {
        return  ResponseEntity.ok(userService.update(id, user));
    }
    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        userService.delete(id);
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody UpdateUserRequest user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
