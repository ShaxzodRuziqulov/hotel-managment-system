package com.example.Hotel.managment.system.config;

import com.example.Hotel.managment.system.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Objects;


@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtService jwtTokenProvider;


    @Autowired
    OAuth2LoginSuccessHandler(JwtService jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(Objects.requireNonNull(oAuth2User.getAttribute("email")).toString());
        getRedirectStrategy().sendRedirect(request, response, UriComponentsBuilder.fromUriString("/me")
                .queryParam("token", token)
                .build().toUriString());
    }


}
