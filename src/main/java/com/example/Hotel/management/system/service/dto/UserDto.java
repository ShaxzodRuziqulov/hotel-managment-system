/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:50
 */
package com.example.Hotel.management.system.service.dto;


import com.example.Hotel.management.system.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String password;
    private Role role;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
