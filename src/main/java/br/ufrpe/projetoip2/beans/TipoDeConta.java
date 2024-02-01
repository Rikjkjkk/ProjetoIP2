package br.ufrpe.projetoip2.beans;

public enum TipoDeConta {
    PADRAO("Padrão"),
    CRITICO("Crítico"),
    ADMIN("Admin");

    private final String nome;

    private TipoDeConta(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
