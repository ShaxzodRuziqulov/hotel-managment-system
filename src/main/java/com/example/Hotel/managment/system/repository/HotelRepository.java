/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:19
 */
package com.example.Hotel.managment.system.repository;

import com.example.Hotel.managment.system.entity.Hotel;
import com.example.Hotel.managment.system.entity.enumirated.HotelStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("update Hotel h set h.hotelStatus=:status where h.id=:id")
    Hotel updateByHotelStatus(@Param("id") Long id, @Param("status") HotelStatus status);

    @Query("select h from Hotel h where h.name LIKE %:name% and h.address LIKE %:address%")
    List<Hotel> findByNameAndAddress(@Param("name") String name, @Param("address") String address);


}
