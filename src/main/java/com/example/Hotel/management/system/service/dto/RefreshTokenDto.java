/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:19.10.2024
 * TIME:15:44
 */
package com.example.Hotel.management.system.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenDto {
    private String email;
    private String password;
}
