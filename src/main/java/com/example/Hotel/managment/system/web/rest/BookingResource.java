/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:10:34
 */
package com.example.Hotel.managment.system.web.rest;

import com.example.Hotel.managment.system.entity.Booking;
import com.example.Hotel.managment.system.service.BookingService;
import com.example.Hotel.managment.system.service.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingResource {

    private final BookingService bookingService;

    public BookingResource(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking/create")
    public ResponseEntity<?> create(@RequestBody BookingDto bookingDto) throws URISyntaxException {
        BookingDto result = bookingService.create(bookingDto);
        return ResponseEntity.created(new URI("/api/booking/create" + result.getId())).body(result);
    }

    @PutMapping("/booking/update/{id}")
    public ResponseEntity<?> update(@RequestBody BookingDto bookingDto, @PathVariable Long id) throws URISyntaxException {
        if (bookingDto.getId() != 0 && !bookingDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        BookingDto result = bookingService.update(bookingDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/booking/all")
    public ResponseEntity<?> findAll() {
        List<BookingDto> findAllBookings = bookingService.findAllBookings();
        return ResponseEntity.ok(findAllBookings);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Booking result = bookingService.findById(id);
        return ResponseEntity.ok(result);
    }

//    @DeleteMapping("/booking/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id) {
//        bookingService.delete(id);
//        return ResponseEntity.ok().build();
//    }
}

