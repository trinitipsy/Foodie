package com.foodie.security;

import com.foodie.model.User;
import com.foodie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<User> user = userRepository.findByEmail(email);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User '" + email + "' not found");
        } else {

            return org.springframework.security.core.userdetails.User
                    .withUsername(email)
                    .password(user.get().getPassword())
                    .authorities(user.get().getRole().getCode())
                    .build();
        }
    }
}