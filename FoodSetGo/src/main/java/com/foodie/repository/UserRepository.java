package com.foodie.repository;

import com.foodie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByActiveTrue();
    Optional<User> findByEmail(String email);
    Integer countUsersByActiveTrue();
}
