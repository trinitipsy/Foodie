package com.foodie.FoodSetGo.repository;

import com.foodie.FoodSetGo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByActiveTrue();
}
