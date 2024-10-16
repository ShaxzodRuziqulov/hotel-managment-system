/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:10:58
 */
package com.example.Hotel.managment.system.entity;

import com.example.Hotel.managment.system.entity.enumirated.HotelStatus;
import com.example.Hotel.managment.system.entity.teamplate.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Entity
@Setter
@Table(name = "hotel")
public class Hotel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private BigDecimal rating;
    @Enumerated(EnumType.STRING)
    private HotelStatus hotelStatus;
}
