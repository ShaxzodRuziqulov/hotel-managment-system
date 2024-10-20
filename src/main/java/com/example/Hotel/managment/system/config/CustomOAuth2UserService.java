package com.example.Hotel.managment.system.config;

import com.example.Hotel.managment.system.entity.User;
import com.example.Hotel.managment.system.entity.enumirated.Status;
import com.example.Hotel.managment.system.repository.RoleRepository;
import com.example.Hotel.managment.system.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CustomOAuth2UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        Set<String> scopes = oAuth2UserRequest.getClientRegistration().getScopes();
        if (!scopes.contains("email") || !scopes.contains("profile")) {
            throw new OAuth2AuthenticationException("Missing required scopes: email, profile");
        }
        String email = oAuth2User.getAttribute("email");
        String fullName = oAuth2User.getAttribute("name");

        User user = userRepository.findByEmail(email).orElseGet(() -> userRepository.save(new User(fullName, email, roleRepository.findByName("ROLE_USER"), Status.ACTIVE)));
        userRepository.save(user);
        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                oAuth2User.getAttributes(), "email");
    }
}
