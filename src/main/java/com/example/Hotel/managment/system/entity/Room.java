/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:01
 */
package com.example.Hotel.managment.system.entity;

import com.example.Hotel.managment.system.entity.enumirated.RoomStatus;
import com.example.Hotel.managment.system.entity.enumirated.RoomType;
import com.example.Hotel.managment.system.entity.teamplate.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

}
