package PROJETO.ReviewRestaurante.Modelo;

public class Restaurante {
    // ATRIBUTOS
    private String nome;
    private TipoComida tipoComida;
    private String descricao;
    private double notaCriticos;
    private double notaPublico;

    // CONSTRUTOR
    public Restaurante(String nome, TipoComida tipoComida, String descricao) {
        this.nome = nome;
        this.tipoComida = tipoComida;
        this.descricao = descricao;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public TipoComida getTipoComida() {
        return this.tipoComida;
    }
    public void setTipoComida(TipoComida TipoComida) {
        this.tipoComida = tipoComida;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getNotaCriticos() {
        return this.notaCriticos;
    }
    public void setNotaCriticos(double notaCriticos) {
        this.notaCriticos = notaCriticos;
    }
    public double getNotaPublico() {
        return this.notaPublico;
    }
    public void setNotaPublico(double notaPublico) {
        this.notaPublico = notaPublico;
    }
}