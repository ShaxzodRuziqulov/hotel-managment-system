/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:19:31
 */
package com.example.Hotel.managment.system.service.mapper;

import com.example.Hotel.managment.system.entity.Booking;
import com.example.Hotel.managment.system.service.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper extends EntityMapper<BookingDto, Booking> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "room.id", target = "roomId")
    @Mapping(source = "bookingStatus", target = "bookingStatus")
    BookingDto toDto(Booking booking);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "bookingStatus", target = "bookingStatus")
    Booking toEntity(BookingDto bookingDto);
}
