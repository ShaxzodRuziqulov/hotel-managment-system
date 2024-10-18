/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.10.2024
 * TIME:23:27
 */
package com.example.Hotel.managment.system.security;

import com.example.Hotel.managment.system.entity.User;
import com.example.Hotel.managment.system.entity.enumirated.Role;
import com.example.Hotel.managment.system.entity.enumirated.Status;
import com.example.Hotel.managment.system.repository.UserRepository;
import com.example.Hotel.managment.system.service.dto.LoginUserDto;
import com.example.Hotel.managment.system.service.dto.RegisterUserDto;
import com.example.Hotel.managment.system.service.dto.UserDto;
import com.example.Hotel.managment.system.service.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 UserMapper userMapper, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
    }

    public UserDto signup(RegisterUserDto input) {
        User user = userMapper.toUser(input);
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setStatus(Status.ACTIVE);
        if (input.getRole() == null) {
            user.setRole(Role.USER);
        }
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
