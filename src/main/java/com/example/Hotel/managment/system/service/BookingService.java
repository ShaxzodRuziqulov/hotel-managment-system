/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:21:25
 */
package com.example.Hotel.managment.system.service;

import com.example.Hotel.managment.system.entity.Booking;
import com.example.Hotel.managment.system.entity.enumirated.BookingStatus;
import com.example.Hotel.managment.system.repository.BookingRepository;
import com.example.Hotel.managment.system.service.dto.BookingDto;
import com.example.Hotel.managment.system.service.mapper.BookingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public BookingDto create(BookingDto bookingDto) {
        Booking booking = bookingMapper.toEntity(bookingDto);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    public BookingDto update(BookingDto bookingDto) {
        Booking booking = bookingMapper.toEntity(bookingDto);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    public List<BookingDto> findAllBookings() {
        return bookingRepository
                .findAll()
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    public Booking findById(Long id) {
        return bookingRepository
                .findById(id)
                .orElseGet(Booking::new);
    }

    public Booking delete(Long id) {
        return bookingRepository.updateByBookingStatus(id, BookingStatus.DELETED);
    }
}
