/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:20.10.2024
 * TIME:12:16
 */
package com.example.Hotel.managment.system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
@Configuration
public class VerificationCodeGenerator {
    public String generateVerificationCode() {
        return UUID.randomUUID().toString();
    }
}
