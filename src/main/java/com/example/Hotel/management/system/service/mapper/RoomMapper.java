/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:19:10
 */
package com.example.Hotel.management.system.service.mapper;

import com.example.Hotel.management.system.entity.Room;
import com.example.Hotel.management.system.service.dto.RoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = HotelMapper.class)
public interface RoomMapper extends EntityMapper<RoomDto, Room> {

    @Mapping(source = "hotel.id", target = "hotelId")
    RoomDto toDto(Room room);

    @Mapping(source = "hotelId", target = "hotel.id")
    Room toEntity(RoomDto roomDto);

    default Room fromId(Long id) {
        if (id == null || id == 0L) {
            return null;
        }
        Room room = new Room();
        room.setId(id);
        return room;
    }
}
