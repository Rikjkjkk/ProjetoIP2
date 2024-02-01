package br.ufrpe.projetoip2.beans;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    // Atributos
    private String nome;
    private List<Restaurante> restaurantes = new ArrayList<>();

    // Construtor
    public Lista(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
}
