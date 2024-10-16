/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:17:07
 */
package com.example.Hotel.managment.system.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class BookingDto {
    private Long id;
    private Long userId;
    private Long roomId;

    private LocalDate startDate;
    private LocalDate endDate;
    private String bookingStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
