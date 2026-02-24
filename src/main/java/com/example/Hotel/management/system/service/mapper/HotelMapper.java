/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:43
 */
package com.example.Hotel.management.system.service.mapper;

import com.example.Hotel.management.system.entity.Hotel;
import com.example.Hotel.management.system.service.dto.HotelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends EntityMapper<HotelDto, Hotel> {
    HotelDto toDto(Hotel hotel);

    Hotel toEntity(HotelDto hotelDto);

    default Hotel fromId(Long id) {
        if (id == null || id == 0L) {
            return null;
        }
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return hotel;
    }
}
