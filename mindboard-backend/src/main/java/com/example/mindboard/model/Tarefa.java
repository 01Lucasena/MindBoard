package com.example.mindboard.model;

import jakarta.persistence.Table;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private Date prazo;

    @Column
    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "lista_tarefas_id", nullable = false)
    private ListaTarefas listaTarefas;

    @Column
    private int posicao;

    @Column
    private String tag;

    @Column
    private Date dataCriacao;

    @Column
    private Date dataAtualizacao;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, Date prazo, boolean concluida, ListaTarefas listaTarefas, int posicao, String tag) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = concluida;
        this.listaTarefas = listaTarefas;
        this.posicao = posicao;
        this.tag = tag;
        this.dataCriacao = new Date(System.currentTimeMillis());
        this.dataAtualizacao = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    public ListaTarefas getListaTarefas() {
        return listaTarefas;
    }
    public void setListaTarefas(ListaTarefas listaTarefas) {
        this.listaTarefas = listaTarefas;
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
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prazo=" + prazo +
                ", concluida=" + concluida +
                ", listaTarefas=" + listaTarefas +
                ", posicao=" + posicao +
                ", tag='" + tag + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
