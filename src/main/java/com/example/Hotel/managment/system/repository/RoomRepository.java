/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:17
 */
package com.example.Hotel.managment.system.repository;

import com.example.Hotel.managment.system.entity.Room;
import com.example.Hotel.managment.system.entity.enumirated.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("update Room r set r.status=:status where r.id=:id")
    Room updateRoomByStatus(@Param("id") Long id, @Param("status") RoomStatus status);
}
