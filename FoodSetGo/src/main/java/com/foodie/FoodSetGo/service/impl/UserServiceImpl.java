package com.foodie.FoodSetGo.service.impl;

import com.foodie.FoodSetGo.dto.UpdateUserRequest;
import com.foodie.FoodSetGo.exception.NotFoundException;
import com.foodie.FoodSetGo.model.Role;
import com.foodie.FoodSetGo.model.User;
import com.foodie.FoodSetGo.repository.RoleRepository;
import com.foodie.FoodSetGo.repository.UserRepository;
import com.foodie.FoodSetGo.security.JwtTokenProvider;
import com.foodie.FoodSetGo.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAllByActiveTrue();
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public User update(String email, UpdateUserRequest userRequest) {
        User user = userRepository.findByEmail(email).orElseThrow(NotFoundException::new);

        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setAddress(userRequest.getAddress());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @Override
    public String save(UpdateUserRequest updateUserRequest) {
        User user = new User();
        user.setName(updateUserRequest.getName());
        user.setSurname(updateUserRequest.getSurname());
        user.setAddress(updateUserRequest.getAddress());
        user.setEmail(updateUserRequest.getEmail());
        user.setPassword(updateUserRequest.getPassword());
        user.setActive(true);
        Role role = roleRepository.findByCode("ROLE_USER").get();
        user.setRole(role);
        userRepository.save(user);
        return logIn(user.getEmail(), user.getPassword());
    }

    @Override
    public String logIn(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.createToken(username, userRepository.findByEmail(username).get().getRole());
    }
}
