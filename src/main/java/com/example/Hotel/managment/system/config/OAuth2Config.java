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
                .clientId("114690352756-e4arg6bpv6fec149g6mfufm8rctihl3p.apps.googleusercontent.com")
                .clientSecret("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")
                .build();

        return new InMemoryClientRegistrationRepository(googleRegistration);
    }
}
