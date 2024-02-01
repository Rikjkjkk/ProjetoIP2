package br.ufrpe.projetoip2.beans;

public enum TipoComida {
    JAPONESA("Japonesa"),
    CHINESA("Chinesa"),
    MARMITA("Marmita"),
    HAMBURGUER("Hamburguer"),
    ITALIANA("Italiana"),
    INDIANA("Indiana"),
    MEXICANA("Mexicana"),
    FASTFOOD("Fast Food"),
    CARNES("Carnes"),
    PIZZA("Pizza");

    private final String nome;

    private TipoComida(String nome) {
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
