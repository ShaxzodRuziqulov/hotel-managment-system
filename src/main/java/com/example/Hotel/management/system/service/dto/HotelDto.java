/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:42
 */
package com.example.Hotel.management.system.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class HotelDto {
    private Long id;
    private String name;
    private String address;
    private BigDecimal rating;
    private String hotelStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
