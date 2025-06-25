package com.example.mindboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuadroCreateDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;

    public QuadroCreateDTO() {}

    public QuadroCreateDTO(String nome, Long usuarioId) {
        this.nome = nome;
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
