package com.example.mindboard.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "listas_tarefas")
public class ListaTarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private int posicao;

    @ManyToOne
    @JoinColumn(name = "quadro_id", nullable = false)
    private Quadro quadro;

    public ListaTarefas() {
    }
    public ListaTarefas(String nome, int posicao, Quadro quadro) {
        this.nome = nome;
        this.posicao = posicao;
        this.quadro = quadro;
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
    public Quadro getQuadro() {
        return quadro;
    }
    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }
    @Override
    public String toString() {
        return "ListaTarefas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", posicao=" + posicao +
                ", quadro=" + quadro +
                '}';
    }

}
