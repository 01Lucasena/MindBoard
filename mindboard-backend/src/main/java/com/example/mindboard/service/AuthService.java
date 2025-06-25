package com.example.mindboard.service;

import com.example.mindboard.dto.JwtAuthResponseDTO;
import com.example.mindboard.dto.UsuarioLoginDTO;
import com.example.mindboard.dto.UsuarioResponseDTO;
import com.example.mindboard.model.Usuario;
import com.example.mindboard.repository.UsuarioRepository;
import com.example.mindboard.config.JwtUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil; // ✅ Adicionado

    public AuthService(UsuarioRepository usuarioRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) { // ✅ Injeção do JwtUtil
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public UsuarioResponseDTO login(UsuarioLoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Senha inválida");
        }

        return new UsuarioResponseDTO(usuario.getNome(), usuario.getEmail());
    }

    public JwtAuthResponseDTO loginComJwt(UsuarioLoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Senha inválida");
        }

        String token = jwtUtil.gerarToken(usuario.getEmail());
        return new JwtAuthResponseDTO(token);
    }
}
