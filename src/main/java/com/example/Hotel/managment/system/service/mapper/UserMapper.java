/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:50
 */
package com.example.Hotel.managment.system.service.mapper;

import com.example.Hotel.managment.system.entity.User;
import com.example.Hotel.managment.system.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role", target = "role")
    @Mapping(source = "status", target = "status")
    UserDto toDto(User user);

    @Mapping(target = "role", source = "role")
    @Mapping(target = "status", source = "status")
    User toEntity(UserDto userDto);
}
