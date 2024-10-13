/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:16:43
 */
package com.example.Hotel.managment.system.service.mapper;

import com.example.Hotel.managment.system.entity.Hotel;
import com.example.Hotel.managment.system.service.dto.HotelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HotelMapper extends EntityMapper<HotelDto, Hotel> {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDto toDto(Hotel hotel);

    Hotel toEntity(HotelDto hotelDto);
}
