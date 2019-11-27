package com.foodie.service.impl;

import com.foodie.dto.UpdateUserRequest;
import com.foodie.exception.NotFoundException;
import com.foodie.model.Role;
import com.foodie.model.User;
import com.foodie.repository.RoleRepository;
import com.foodie.repository.UserRepository;
import com.foodie.security.JwtTokenProvider;
import com.foodie.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAllByActiveTrue();
    }

    @Override
    public User get(String username) {
        return userRepository.findByEmail(username).orElseThrow(NotFoundException::new);
    }

    @Override
    public User delete(String username) {
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);
        user.setActive(false);
        return userRepository.save(user);
    }

    @Override
    public User update(String username, UpdateUserRequest userRequest) {
        User user = userRepository.findByEmail(username).orElseThrow(NotFoundException::new);
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setAddress(userRequest.getAddress());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @Override
    public String add(UpdateUserRequest updateUserRequest) {
        User user = new User();
        user.setName(updateUserRequest.getName());
        user.setSurname(updateUserRequest.getSurname());
        user.setAddress(updateUserRequest.getAddress());
        user.setEmail(updateUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        user.setActive(true);
        Role role = roleRepository.findByCode("ROLE_USER").get();
        user.setRole(role);
        userRepository.save(user);
        return logIn(user.getEmail(), updateUserRequest.getPassword());
    }

    @Override
    public String logIn(String username, String password) {


        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.createToken(username, userRepository.findByEmail(username).get().getRole());
    }
}
