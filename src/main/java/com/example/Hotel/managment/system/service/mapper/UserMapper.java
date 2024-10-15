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

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    default User fromId(Long id) {
        if (id == 0) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
