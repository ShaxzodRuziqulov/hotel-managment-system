/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:05
 */
package com.example.Hotel.managment.system.entity;

import com.example.Hotel.managment.system.entity.enumirated.Role;
import com.example.Hotel.managment.system.entity.enumirated.Status;
import com.example.Hotel.managment.system.entity.teamplate.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean isEnabled;
}
