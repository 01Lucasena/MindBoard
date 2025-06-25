package com.example.mindboard.controller;

import com.example.mindboard.dto.JwtAuthResponseDTO;
import com.example.mindboard.dto.UsuarioLoginDTO;
import com.example.mindboard.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UsuarioLoginDTO dto) {
        try {
            JwtAuthResponseDTO jwt = authService.loginComJwt(dto);
            return ResponseEntity.ok(jwt);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(401).body(Map.of("error", ex.getMessage()));
        }
    }
}
