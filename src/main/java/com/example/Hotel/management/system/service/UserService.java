/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:49
 */
package com.example.Hotel.management.system.service;

import com.example.Hotel.management.system.entity.User;
import com.example.Hotel.management.system.entity.enumirated.Status;
import com.example.Hotel.management.system.exeption.BadRequestException;
import com.example.Hotel.management.system.repository.UserRepository;
import com.example.Hotel.management.system.service.dto.UserDto;
import com.example.Hotel.management.system.service.mapper.UserMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto update(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public List<UserDto> findAllUser() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("User not found: " + id));
    }

    public User delete(Long id) {
        User user = findById(id);
        user.setStatus(Status.DELETE);
        return userRepository.save(user);
    }

    public Page<User> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    public User findActiveUserByEmail(String email) {
        return userRepository.findActiveUserByEmail(email, Status.ACTIVE);
    }
}
