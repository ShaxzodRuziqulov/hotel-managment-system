package com.example.Hotel.management.system.config;

import com.example.Hotel.management.system.entity.Role;
import com.example.Hotel.management.system.entity.User;
import com.example.Hotel.management.system.entity.enumirated.Status;
import com.example.Hotel.management.system.repository.RoleRepository;
import com.example.Hotel.management.system.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class PreInject {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private Role createRole(String name, String description) {
        return Role.builder()
                .name(name)
                .description(description)
                .build();
    }

    @PostConstruct
    @Transactional
    public void setDefaultUsers() {
        if (roleRepository.count() == 0) {
            List<Role> roles = new ArrayList<>();
            roles.add(createRole("ROLE_ADMIN", "Admin"));
            roles.add(createRole("ROLE_USER", "User"));
            roleRepository.saveAll(roles);
        }

        if (userRepository.count() == 0) {
            User user = new User();
            user.setUserName("admin");
            user.setRole(roleRepository.findByName("ROLE_ADMIN"));
            user.setFullName("full_name");
            user.setStatus(Status.ACTIVE);
            user.setEmail("admin@gmail.com");
            user.setPassword(encodePassword("123"));
            userRepository.save(user);
        }
    }
}
