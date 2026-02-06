/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:13
 */
package com.example.Hotel.management.system.entity;

import com.example.Hotel.management.system.entity.enumirated.PaymentMethod;
import com.example.Hotel.management.system.entity.enumirated.PaymentStatus;
import com.example.Hotel.management.system.entity.teamplate.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private BigDecimal amount;
    private Timestamp paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

}
