/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:10:38
 */
package com.example.Hotel.managment.system.web.rest;

import com.example.Hotel.managment.system.entity.Hotel;
import com.example.Hotel.managment.system.service.HotelService;
import com.example.Hotel.managment.system.service.dto.HotelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelResource {

    private final HotelService hotelService;

    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/hotel/create")
    public ResponseEntity<?> create(@RequestBody HotelDto hotelDto) throws URISyntaxException {
        HotelDto result = hotelService.create(hotelDto);
        return ResponseEntity.created(new URI("/api/hotel/create" + result.getId())).body(result);
    }

    @PutMapping("/hotel/update/{id}")
    public ResponseEntity<?> update(@RequestBody HotelDto hotelDto, @PathVariable Long id) throws URISyntaxException {
        if (hotelDto.getId() != 0 && !hotelDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        HotelDto result = hotelService.update(hotelDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/hotel/all")
    public ResponseEntity<?> findAll() {
        List<HotelDto> findAllHotels = hotelService.findAllHotels();
        return ResponseEntity.ok(findAllHotels);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Hotel result = hotelService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/hotel/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hotel/find/{name}/{address}")
    public ResponseEntity<?> findByNameAndAddress(@PathVariable String name, @PathVariable String address) {
        List<HotelDto> dtoList = hotelService.findByNameAndAddress(name, address);
        return ResponseEntity.ok(dtoList);
    }
}

