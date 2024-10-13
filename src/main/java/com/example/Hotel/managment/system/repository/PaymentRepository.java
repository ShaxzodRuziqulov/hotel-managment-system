/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:20
 */
package com.example.Hotel.managment.system.repository;

import com.example.Hotel.managment.system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
