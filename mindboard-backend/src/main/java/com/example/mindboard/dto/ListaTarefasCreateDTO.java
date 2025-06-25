package com.example.mindboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ListaTarefasCreateDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private int posicao;

    @NotNull(message = "ID do quadro é obrigatório")
    private Long quadroId;

    public ListaTarefasCreateDTO() {}

    public ListaTarefasCreateDTO(String nome, int posicao, Long quadroId) {
        this.nome = nome;
        this.posicao = posicao;
        this.quadroId = quadroId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Long getQuadroId() {
        return quadroId;
    }

    public void setQuadroId(Long quadroId) {
        this.quadroId = quadroId;
    }
}


