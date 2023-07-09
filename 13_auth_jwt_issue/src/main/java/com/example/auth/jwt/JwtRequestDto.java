package com.example.auth.jwt;

import lombok.Data;

@Data
public class JwtRequestDto {
    private String username;
    private String password;
}
