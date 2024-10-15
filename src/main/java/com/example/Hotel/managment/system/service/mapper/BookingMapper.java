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

@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<BookingDto, Booking> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "room.id", target = "roomId")
    BookingDto toDto(Booking booking);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roomId", target = "room.id")
    Booking toEntity(BookingDto bookingDto);

    default Booking fromId(Long id) {
        if (id == 0) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(id);
        return booking;
    }
}
