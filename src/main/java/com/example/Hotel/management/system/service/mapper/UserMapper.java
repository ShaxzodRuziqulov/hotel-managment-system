/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:50
 */
package com.example.Hotel.management.system.service.mapper;


import com.example.Hotel.management.system.entity.User;
import com.example.Hotel.management.system.service.dto.RegisterUserDto;
import com.example.Hotel.management.system.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = RoleMapper.class)
public interface UserMapper extends EntityMapper<UserDto, User> {

    @Mapping(source = "username", target = "userName")
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
    @Mapping(source = "roleId", target = "role.id")
    User toUser(RegisterUserDto registerUserDto);

    default User fromId(Long id) {
        if (id == 0) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}
