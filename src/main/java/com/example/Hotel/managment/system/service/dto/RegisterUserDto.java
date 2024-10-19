/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:18.10.2024
 * TIME:22:13
 */
package com.example.Hotel.managment.system.service.dto;

import com.example.Hotel.managment.system.entity.Role;
import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;

    private String password;

    private String userName;

    private Long roleId;
}
