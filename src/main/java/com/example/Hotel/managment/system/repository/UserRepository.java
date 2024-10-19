/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:48
 */
package com.example.Hotel.managment.system.repository;

import com.example.Hotel.managment.system.entity.User;
import com.example.Hotel.managment.system.entity.enumirated.Status;
import com.example.Hotel.managment.system.service.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("update User u set u.status=:status where u.id=:id")
    User updateStatus(@Param("id") Long id, @Param("status") Status status);

    @Query("select u from User u where u.email=:email and u.status=:status")
    User findActiveUserByEmail(@Param("email") String email, @Param("status") Status status);

    Optional<User> findByUserName(String userName);
}
