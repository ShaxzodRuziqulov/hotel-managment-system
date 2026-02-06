/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:19:40
 */
package com.example.Hotel.management.system.service;

import com.example.Hotel.management.system.entity.Hotel;
import com.example.Hotel.management.system.entity.enumirated.HotelStatus;
import com.example.Hotel.management.system.repository.HotelRepository;
import com.example.Hotel.management.system.service.dto.HotelDto;
import com.example.Hotel.management.system.service.mapper.HotelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    public HotelDto create(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        hotel = hotelRepository.save(hotel);
        return hotelMapper.toDto(hotel);
    }

    public HotelDto update(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        hotel = hotelRepository.save(hotel);
        return hotelMapper.toDto(hotel);
    }

    public List<HotelDto> findAllHotels() {
        return hotelRepository
                .findAll()
                .stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());
    }

    public Hotel findById(Long id) {
        return hotelRepository
                .findById(id)
                .orElseGet(Hotel::new);
    }

    public Hotel delete(Long id) {
        return hotelRepository.updateByHotelStatus(id, HotelStatus.DELETE);
    }

    public List<HotelDto> findByNameAndAddress(String name, String address) {
        return hotelRepository.findByNameAndAddress(name, address)
                .stream()
                .map(hotelMapper::toDto)
                .collect(Collectors
                        .toList());
    }

}
