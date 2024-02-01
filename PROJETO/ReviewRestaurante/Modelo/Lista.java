package PROJETO.ReviewRestaurante.Modelo;
import java.util.ArrayList;
import java.util.List;

public class Lista {
    // ATRIBUTOS
    private String nome;
    private List<Restaurante> restaurantes = new ArrayList<>();

    // CONSTRUTOR
    public Lista(String nome) {
        this.nome = nome;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Restaurante> getFilmes() {
        return this.restaurantes;
    }
    public void setFilmes(List<Restaurante> filmes) {
        this.restaurantes = filmes;
    }
    
}
