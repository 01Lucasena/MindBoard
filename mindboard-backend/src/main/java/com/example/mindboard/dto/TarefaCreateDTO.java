package com.example.mindboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class TarefaCreateDTO {

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    private String descricao;

    private Date prazo;

    @NotNull(message = "ID da lista de tarefas é obrigatório")
    private Long listaTarefasId;

    private int posicao;
    private String tag;

    public TarefaCreateDTO() {}

    public TarefaCreateDTO(String titulo, String descricao, Date prazo, Long listaTarefasId, int posicao, String tag) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.listaTarefasId = listaTarefasId;
        this.posicao = posicao;
        this.tag = tag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Long getListaTarefasId() {
        return listaTarefasId;
    }

    public void setListaTarefasId(Long listaTarefasId) {
        this.listaTarefasId = listaTarefasId;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
