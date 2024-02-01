package br.ufrpe.projetoip2.beans;

import java.time.LocalDateTime;

public class Avaliacao {
    // Atributos
    private Usuario usuario;
    private Restaurante restaurante;
    private String comentario;
    private double nota;
    private LocalDateTime dataAvaliacao;

    // Construtor
    public Avaliacao(Usuario usuario, Restaurante restaurante, String comentario, double nota) {
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.comentario = comentario;
        this.nota = nota;
        this.dataAvaliacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
