package com.example.Hotel.managment.system.web.rest;

import com.example.Hotel.managment.system.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeResource {
    private final JwtService jwtTokenProvider;

    public HomeResource(JwtService jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("me")
    public ResponseEntity<?> getMe(@RequestParam("token") String tokenHeader) {
        if (tokenHeader != null) {
            if (jwtTokenProvider.isTokenValid(tokenHeader)) {
                String email = jwtTokenProvider.getUsernameFromToken(tokenHeader);
                return ResponseEntity.ok(Map.of("email", email));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");

    }
}
