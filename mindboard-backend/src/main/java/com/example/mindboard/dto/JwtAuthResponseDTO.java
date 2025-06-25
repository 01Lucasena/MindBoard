package com.example.mindboard.dto;

public class JwtAuthResponseDTO {
    private String token;

    public JwtAuthResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
