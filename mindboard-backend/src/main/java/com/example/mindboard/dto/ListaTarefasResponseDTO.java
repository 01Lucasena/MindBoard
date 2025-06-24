package com.example.mindboard.dto;

public class ListaTarefasResponseDTO {

    private Long id;
    private String nome;
    private int posicao;

    public ListaTarefasResponseDTO() {}

    public ListaTarefasResponseDTO(Long id, String nome, int posicao) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
