package com.foodie.FoodSetGo.repository;

import com.foodie.FoodSetGo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByActiveTrue();
    Optional<User> findByEmail(String email);
}
