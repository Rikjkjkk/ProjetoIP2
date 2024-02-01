package br.ufrpe.projetoip2.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    // Atributos
    private String nome;
    private TipoComida tipoComida;
    private String descricao;
    private double notaPublico;
    private double notaCriticos;

    // Lista de avaliações do público
    private List<Avaliacao> avaliacoesPublico = new ArrayList<>();

    // Lista de avaliações dos críticos
    private List<Avaliacao> avaliacoesCriticos = new ArrayList<>();

    // Construtor
    public Restaurante(String nome, TipoComida tipoComida, String descricao) {
        this.nome = nome;
        this.tipoComida = tipoComida;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNotaCriticos() {
        return notaCriticos;
    }

    public void setNotaCriticos(double notaCriticos) {
        this.notaCriticos = notaCriticos;
    }

    public double getNotaPublico() {
        return notaPublico;
    }

    public void setNotaPublico(double notaPublico) {
        this.notaPublico = notaPublico;
    }

    public List<Avaliacao> getAvaliacoesPublico() {
        return avaliacoesPublico;
    }

    public void setAvaliacoesPublico(List<Avaliacao> avaliacoesPublico) {
        this.avaliacoesPublico = avaliacoesPublico;
    }

    public List<Avaliacao> getAvaliacoesCriticos() {
        return avaliacoesCriticos;
    }

    public void setAvaliacoesCriticos(List<Avaliacao> avaliacoesCriticos) {
        this.avaliacoesCriticos = avaliacoesCriticos;
    }
}
