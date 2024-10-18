/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:13.10.2024
 * TIME:11:54
 */
package com.example.Hotel.managment.system.web.rest;

import com.example.Hotel.managment.system.entity.User;
import com.example.Hotel.managment.system.service.UserService;
import com.example.Hotel.managment.system.service.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    //
    @PostMapping("/user/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) throws URISyntaxException {
        UserDto result = userService.create(userDto);
        return ResponseEntity.created(new URI("/api/user/create" + result.getId())).body(result);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable Long id) throws URISyntaxException {
        if (userDto.getId() != 0 && !userDto.getId().equals(id)) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        UserDto result = userService.update(userDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/user/all")
    public ResponseEntity<?> findAll() {
        List<UserDto> findAllUser = userService.findAllUser();
        return ResponseEntity.ok(findAllUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        User result = userService.findById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        User user = userService.delete(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/page")
    public ResponseEntity<?> getUsers(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        Page<User> userPage = userService.getUsers(page, size);
        return ResponseEntity.ok(userPage);
    }

    @GetMapping("/user/find/{email}")
    public ResponseEntity<?> findActiveUserByEmail(@PathVariable String email) {
        User result = userService.findActiveUserByEmail(email);
        return ResponseEntity.ok(result);
    }
}
