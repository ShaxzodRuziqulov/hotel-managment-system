/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:18
 */
package com.example.Hotel.managment.system.repository;

import com.example.Hotel.managment.system.entity.Booking;
import com.example.Hotel.managment.system.entity.enumirated.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Query("update Booking b set b.bookingStatus=:status where b.id=:id")
    Booking updateByBookingStatus(@Param("id") Long id, @Param("status")BookingStatus status);


}
