/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.10.2024
 * TIME:23:52
 */
package com.example.Hotel.management.system.web.rest;

import com.example.Hotel.management.system.entity.User;
import com.example.Hotel.management.system.model.response.LoginResponse;
import com.example.Hotel.management.system.model.response.RefreshTokenResponse;
import com.example.Hotel.management.system.repository.UserRepository;
import com.example.Hotel.management.system.security.JwtService;
import com.example.Hotel.management.system.service.AuthenticationService;
import com.example.Hotel.management.system.service.dto.LoginUserDto;
import com.example.Hotel.management.system.service.dto.RefreshTokenDto;
import com.example.Hotel.management.system.service.dto.RegisterUserDto;
import com.example.Hotel.management.system.service.dto.UserDto;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationResource {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    public AuthenticationResource(JwtService jwtService, AuthenticationService authenticationService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody RegisterUserDto registerUserDto) throws MessagingException {
        UserDto registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String code) {
        User user = userRepository.findByVerificationCode(code);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid verification code.");
        }

        user.setVerificationCode(null);
        userRepository.save(user);

        return ResponseEntity.ok("User verified successfully.");
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<RefreshTokenResponse> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {

        User refreshTokenUser = authenticationService.authenticateRefresh(refreshTokenDto);

        String rwtToken = jwtService.generateRefreshToken(refreshTokenUser);

        RefreshTokenResponse refreshTokenResponse = RefreshTokenResponse.builder().token(rwtToken).expiresIn(jwtService.getExpirationTimeRefresh()).build();

        return ResponseEntity.ok(refreshTokenResponse);

    }

}
