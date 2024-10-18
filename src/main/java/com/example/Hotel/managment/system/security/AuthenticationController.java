/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.10.2024
 * TIME:23:52
 */
package com.example.Hotel.managment.system.security;

import com.example.Hotel.managment.system.entity.User;
import com.example.Hotel.managment.system.security.response.LoginResponse;
import com.example.Hotel.managment.system.service.dto.LoginUserDto;
import com.example.Hotel.managment.system.service.dto.RegisterUserDto;
import com.example.Hotel.managment.system.service.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody RegisterUserDto userDto) {
        UserDto registeredUser = authenticationService.signup(userDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
