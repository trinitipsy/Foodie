package com.foodie.service;

import com.foodie.dto.UpdateUserRequest;
import com.foodie.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User get(final String email);

    User delete(final String username);

    User update(final String email, final UpdateUserRequest user);

    String add(final UpdateUserRequest user);

    String logIn(final String username, final String password);
}
