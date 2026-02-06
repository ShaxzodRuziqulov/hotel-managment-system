/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:17:29
 */
package com.example.Hotel.management.system.service.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class RoomDto {
    private Long id;
    private Long hotelId;

    private String roomType;
    private BigDecimal price;
    private String roomStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
