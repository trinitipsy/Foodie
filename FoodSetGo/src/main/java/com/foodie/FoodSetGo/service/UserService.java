package com.foodie.FoodSetGo.service;

import com.foodie.FoodSetGo.dto.UpdateUserRequest;
import com.foodie.FoodSetGo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User get(Integer id);
    void delete(Integer id);
    User update(Integer id, UpdateUserRequest user);
    User save(UpdateUserRequest user);
    String logIn(String username, String password);
}
