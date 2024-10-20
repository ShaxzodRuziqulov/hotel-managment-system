package com.example.Hotel.managment.system.config;

import com.example.Hotel.managment.system.security.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtService jwtTokenProvider;

    public OAuth2LoginSuccessHandler(JwtService jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Get the authenticated user
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        // Generate JWT token
        String token = jwtTokenProvider.generateToken(oAuth2User.getAttribute("email"));

        // Set token in response header or body
        response.setHeader("Authorization", "Bearer " + token);

        // Redirect user to home page or wherever needed
        getRedirectStrategy().sendRedirect(request, response, "/");
    }
}
