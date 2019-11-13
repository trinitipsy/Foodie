package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.UpdateUserRequest;
import com.foodie.FoodSetGo.model.User;
import com.foodie.FoodSetGo.repository.UserRepository;
import com.foodie.FoodSetGo.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).get();
    }


    @Override
    public void delete(Integer id) {
        Optional<User> userForDelete = userRepository.findById(id);
        if (!userForDelete.isPresent()) {
            throw new EntityNotFoundException();
        }
        userRepository.deleteById(id);
    }

    @Override
    public User update(Integer id, UpdateUserRequest user) {
        Optional<User> userForUpdate = userRepository.findById(id);
        if (!userForUpdate.isPresent()) {
            throw new EntityNotFoundException();
        }
        User user1 = userForUpdate.get();
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setAddress(user.getAddress());
        System.out.println(user1.getId() + user1.getName() +user1.getSurname() + user1.getAddress());
        return userRepository.save(user1);
    }

    @Override
    public User save(UpdateUserRequest updateUserRequest) {
        User user = new User();
        user.setName(updateUserRequest.getName());
        user.setSurname(updateUserRequest.getSurname());
        user.setAddress(updateUserRequest.getAddress());
        return userRepository.save(user);
    }
}
