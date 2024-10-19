package com.example.Hotel.managment.system.service.mapper;

import com.example.Hotel.managment.system.entity.Role;
import com.example.Hotel.managment.system.service.dto.RoleDto;

public interface RoleMapper extends EntityMapper<RoleDto, Role> {
    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);

    default Role fromId(Long id) {
        if (id == 0) {
            return null;
        }
        Role role = new Role();
        role.setId(id);
        return role;
    }
}
