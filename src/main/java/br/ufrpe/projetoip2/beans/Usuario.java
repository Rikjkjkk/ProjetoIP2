package br.ufrpe.projetoip2.beans;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos
    private String nome;
    private String login;
    private String senha;
    private TipoDeConta tipo;
    private List<Lista> listas;

    // Construtor
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = TipoDeConta.PADRAO;
        this.listas = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDeConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeConta tipo) {
        this.tipo = tipo;
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }

    // Métodos para adicionar e remover listas do usuário
    public void adicionarLista(Lista lista){
        listas.add(lista);
    }
    public void removerLista(Lista lista){
        listas.remove(lista);
    }
}
