/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:10:42
 */
package com.example.Hotel.managment.system.web.rest;

import com.example.Hotel.managment.system.entity.Room;
import com.example.Hotel.managment.system.service.RoomService;
import com.example.Hotel.managment.system.service.dto.RoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomResource {

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room/create")
    public ResponseEntity<?> create(@RequestBody RoomDto roomDto) throws URISyntaxException {
        RoomDto result = roomService.create(roomDto);
        return ResponseEntity.created(new URI("/api/room/create" + result.getId())).body(result);
    }

    @PutMapping("/room/update/{id}")
    public ResponseEntity<?> update(@RequestBody RoomDto roomDto, @PathVariable Long id) throws URISyntaxException {
        if (roomDto.getId() != 0 && !roomDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        RoomDto result = roomService.update(roomDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/room/all")
    public ResponseEntity<?> findAll() {
        List<RoomDto> findAllRooms = roomService.findAllRooms();
        return ResponseEntity.ok(findAllRooms);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Room result = roomService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/room/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roomService.delete(id);
        return ResponseEntity.ok().build();
    }
}

