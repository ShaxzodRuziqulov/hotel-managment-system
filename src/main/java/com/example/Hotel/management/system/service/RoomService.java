/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:8:56
 */
package com.example.Hotel.management.system.service;

import com.example.Hotel.management.system.entity.Room;
import com.example.Hotel.management.system.entity.enumirated.RoomStatus;
import com.example.Hotel.management.system.entity.enumirated.RoomType;
import com.example.Hotel.management.system.exeption.BadRequestException;
import com.example.Hotel.management.system.repository.RoomRepository;
import com.example.Hotel.management.system.service.dto.RoomDto;
import com.example.Hotel.management.system.service.mapper.RoomMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDto create(RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        room = roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    public RoomDto update(RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        room = roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    public List<RoomDto> findAllRooms() {
        return roomRepository
                .findAll()
                .stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    public Room findById(Long id) {
        return roomRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Room not found: " + id));
    }

    public Room delete(Long id) {
        Room room = findById(id);
        room.setRoomStatus(RoomStatus.DELETED);
        return roomRepository.save(room);
    }

    public List<Room> roomCategory(String category) {
        RoomType roomType;
        try {
            roomType = RoomType.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid room type category: " + category);
        }
        return roomRepository.findByRoomType(roomType);
    }

    public List<Room> findByRoomTypeAndAndPriceRange(RoomType roomType, BigDecimal minPrice, BigDecimal maxPrice) {
        return roomRepository.findByRoomTypeAndPriceRange(roomType, minPrice, maxPrice);
    }

}

