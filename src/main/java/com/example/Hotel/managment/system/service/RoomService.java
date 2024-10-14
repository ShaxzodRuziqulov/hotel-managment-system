/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:8:56
 */
package com.example.Hotel.managment.system.service;

import com.example.Hotel.managment.system.entity.Room;
import com.example.Hotel.managment.system.entity.enumirated.RoomStatus;
import com.example.Hotel.managment.system.repository.RoomRepository;
import com.example.Hotel.managment.system.service.dto.RoomDto;
import com.example.Hotel.managment.system.service.mapper.RoomMapper;
import org.springframework.stereotype.Service;

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
                .orElseGet(Room::new);
    }

    public Room delete(Long id) {
        return roomRepository
                .updateRoomByStatus(id, RoomStatus.DELETED);
    }
}

