/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:19.10.2024
 * TIME:22:00
 */
package com.example.Hotel.managment.system.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;

@Configuration
public class OAuth2Config {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration googleRegistration = ClientRegistrations
                .fromIssuerLocation("https://accounts.google.com")
                .clientId("724343535278-dm00f9f3151iihk1di485onq895ev646.apps.googleusercontent.com")
                .clientSecret("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")
                .build();

        return new InMemoryClientRegistrationRepository(googleRegistration);
    }
}
