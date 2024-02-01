package ReviewRestaurante.Modelo;
import java.util.List;

public class Usuario {
    // ATRIBUTOS
    private String nome;
    private String login;
    private String senha;
    private TipoDeConta tipo; 
    private List<Lista> listas;

    // CONSTRUTOR
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = TipoDeConta.PADRAO;
    }

    // GETTERS E SETTERS
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogin() {
        return this.login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public TipoDeConta getTipo() {
        return this.tipo;
    }
    public void setTipo(TipoDeConta tipo) {
        this.tipo = tipo;
    }
    public List<Lista> getListas() {
        return this.listas;
    }
    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }
    public void adicionarLista(Lista lista) {
        listas.add(lista);
    }
    public void removerLista(Lista lista) {
        listas.remove(lista);
    }

}