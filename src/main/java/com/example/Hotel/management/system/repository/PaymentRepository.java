/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:20
 */
package com.example.Hotel.management.system.repository;

import com.example.Hotel.management.system.entity.Payment;
import com.example.Hotel.management.system.entity.enumirated.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("update Payment p set p.paymentStatus=:status where p.id=:id")
    Payment updateByPaymentStatus(@Param("id") Long id, @Param("status") PaymentStatus paymentStatus);
}
