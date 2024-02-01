package PROJETO.ReviewRestaurante.Modelo;

import java.time.LocalDateTime;

public class Avaliacao {
    // ATRIBUTOS
    private LocalDateTime data;
    private Usuario usuario;
    private Restaurante restaurante;
    private String comentario;
    private double nota;

    // CONSTRUTOR
    public Avaliacao(Usuario usuario, Restaurante restaurante, String comentario, double nota) {
        this.data = LocalDateTime.now();
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.comentario = comentario;
        this.nota = nota;
    }

    // GETTERS E SETTERS
    public LocalDateTime getData() {
        return this.data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Restaurante getRestaurante() {
        return this.restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    public String getComentario() {
        return this.comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public double getNota() {
        return this.nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

}
