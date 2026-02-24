/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:17
 */
package com.example.Hotel.management.system.repository;

import com.example.Hotel.management.system.entity.Room;
import com.example.Hotel.management.system.entity.enumirated.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "select r from Room  r where r.roomType=:category")
    List<Room> findByRoomType(@Param("category") RoomType category);

    @Query("select r from Room r where r.roomType=:roomType and r.price BETWEEN :minPrice and :maxPrice")
    List<Room> findByRoomTypeAndPriceRange(@Param("roomType") RoomType roomType,
                                           @Param("minPrice") BigDecimal minPrice,
                                           @Param("maxPrice") BigDecimal maxPrice);
}
