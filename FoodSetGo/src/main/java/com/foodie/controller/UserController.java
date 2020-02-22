package com.foodie.controller;

import com.foodie.constants.Cors;
import com.foodie.dto.LoginRequest;
import com.foodie.dto.TokenResponse;
import com.foodie.dto.UpdateUserRequest;
import com.foodie.model.User;
import com.foodie.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/get")
    public ResponseEntity<User> get(Authentication authentication) {
        return ResponseEntity.ok(userService.get(authentication.getName()));
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> count() {
        return ResponseEntity.ok(userService.count());
    }

    @PutMapping
    public ResponseEntity<?> update(Authentication authentication, @RequestBody final UpdateUserRequest user) {
        return ResponseEntity.ok(userService.update(authentication.getName(), user));
    }

    @DeleteMapping
    public void delete(Authentication authentication) {
        userService.delete(authentication.getName());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid final UpdateUserRequest user) {
        String token = userService.add(user);
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody final LoginRequest loginRequest) {
        String token = userService.logIn(loginRequest.getUsername(), loginRequest.getPassword());
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return ResponseEntity.ok(tokenResponse);
    }

}

