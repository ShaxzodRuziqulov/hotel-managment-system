/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:19.10.2024
 * TIME:15:42
 */
package com.example.Hotel.managment.system.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RefreshTokenResponse {
    private String token;

    private long expiresIn;
}
