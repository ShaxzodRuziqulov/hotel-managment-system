/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.10.2024
 * TIME:23:27
 */
package com.example.Hotel.management.system.service;

import com.example.Hotel.management.system.entity.User;
import com.example.Hotel.management.system.entity.enumirated.Status;
import com.example.Hotel.management.system.repository.RoleRepository;
import com.example.Hotel.management.system.repository.UserRepository;
import com.example.Hotel.management.system.service.dto.LoginUserDto;
import com.example.Hotel.management.system.service.dto.RefreshTokenDto;
import com.example.Hotel.management.system.service.dto.RegisterUserDto;
import com.example.Hotel.management.system.service.dto.UserDto;
import com.example.Hotel.management.system.service.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final EmailService emailService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder,
                                 UserMapper userMapper,
                                 EmailService emailService,
                                 AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.emailService = emailService;
        this.authenticationManager = authenticationManager;
    }

    public UserDto signup(RegisterUserDto input) {
        User user = userMapper.toUser(input);
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setStatus(Status.PENDING);
        if (input.getRoleId() == null) {
            user.setRole(roleRepository.findByName("ROLE_USER"));
        }
        String verificationCode = generateVerificationCode();
        user.setVerificationCode(verificationCode);

        userRepository.save(user);

        sendVerificationEmail(user.getEmail(), verificationCode);

        return userMapper.toDto(user);
    }

    private String generateVerificationCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    private void sendVerificationEmail(String email, String verificationCode) {
        String subject = "Please verify your email";
        String body = "Your verification code is: " + verificationCode;
        emailService.sendEmail(email, subject, body);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    public User authenticateRefresh(RefreshTokenDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
