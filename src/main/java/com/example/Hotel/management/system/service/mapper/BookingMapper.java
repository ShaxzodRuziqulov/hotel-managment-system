/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:19:31
 */
package com.example.Hotel.management.system.service.mapper;

import com.example.Hotel.management.system.entity.Booking;
import com.example.Hotel.management.system.service.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoomMapper.class})
public interface BookingMapper extends EntityMapper<BookingDto, Booking> {


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "room.id", target = "roomId")
    BookingDto toDto(Booking booking);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roomId", target = "room.id")
    Booking toEntity(BookingDto bookingDto);

    default Booking fromId(Long id) {
        if (id == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setId(id);
        return booking;
    }
}
