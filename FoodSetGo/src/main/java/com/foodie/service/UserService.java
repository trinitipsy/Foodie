package com.foodie.service;

import com.foodie.dto.UpdateUserRequest;
import com.foodie.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAll();

    User get(final String email);

    Map<String, Integer> count();

    User delete(final String username);

    String update(final String email, final UpdateUserRequest user);

    String add(final UpdateUserRequest user);

    String logIn(final String username, final String password);
}
