package br.ufrpe.projetoip2.negocio;

import br.ufrpe.projetoip2.beans.Lista;
import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.dados.IRepositorioGenerico;
import br.ufrpe.projetoip2.dados.RepositorioGenerico;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;
import br.ufrpe.projetoip2.exception.ParametroInvalidoException;
import br.ufrpe.projetoip2.exception.SenhaIncorretaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorUsuario {
    private final IRepositorioGenerico<Usuario> repositorioUsuarios;
    private static ControladorUsuario instancia;

    // Controlador
    public ControladorUsuario() {
        this.repositorioUsuarios = new RepositorioGenerico<>();
    }

    // Pega a instância do controlador
    public static ControladorUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    // Faz o login do usuário com o login e a senha informados
    public boolean login(String login, String senha) throws SenhaIncorretaException, ObjetoInvalidoException {
        List<Usuario> usuarios = this.listarUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                if (usuario.getSenha().equals(senha)) {
                    ControladorSessao.getInstancia().abrirSessao(usuario);
                    return true;
                }
                else {
                    throw new SenhaIncorretaException();
                }
            }
        }
        throw new ObjetoInvalidoException(login);
    }

    // Desloga o usuário do sistema
    public void logoff() {
        ControladorSessao.getInstancia().encerrarSessao();
    }

    public Usuario getUsuario() {
        return instancia.getUsuario();
    }

    // CRUD
    public void adicionarUsuario(Usuario usuario) throws ObjetoJaExisteException, ObjetoInvalidoException {
        if (usuario != null){
            if(!usuario.getNome().isEmpty() && !usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty() && usuario.getTipo() != null && usuario.getListas() != null){
                repositorioUsuarios.adicionar(usuario);
            }
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuarios.listar();
    }

    public void removerUsuario(Usuario usuario) throws ObjetoInvalidoException {
        if (usuario != null){
            repositorioUsuarios.remover(usuario);
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public void editarUsuario(Usuario usuario, Usuario novo) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if(!listarUsuarios().contains(novo)){
            if (usuario != null && novo != null){
                if(!novo.getNome().isEmpty() && !novo.getLogin().isEmpty() && !novo.getSenha().isEmpty() && novo.getTipo() != null && novo.getListas() != null){
                    repositorioUsuarios.editar(usuario, novo);
                }
            }
            else {
                throw new ObjetoInvalidoException(usuario);
            }
        }
        else{
            throw new ObjetoJaExisteException(novo);
        }
    }

    // Buscar um usuário passando ele como parâmetro
    public List<Usuario> buscarUsuario(Object T) throws ObjetoInvalidoException {
        List<Usuario> usuarios = this.listarUsuarios();
        if (T instanceof String palavra) {
            if (palavra.isBlank()) {
                return usuarios;
            }
            else {
                List<Usuario> resultados = new ArrayList<>();
                for (Usuario usuario : usuarios) {
                    String[] palavras = usuario.getNome().split("\\s+");
                    for (String p : palavras) {
                        if(p.equalsIgnoreCase(palavra)) {
                            resultados.add(usuario);
                            break;
                        }
                    }
                }
                return resultados;
            }
        }
        else if (T instanceof TipoDeConta tipo) {
            List<Usuario> resultados = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario.getTipo().equals(tipo)) {
                    resultados.add(usuario);
                }
            }
            return resultados;
        }
        else {
            throw new ObjetoInvalidoException();
        }
    }

    // Buscar um usuário pelo login
    public Usuario buscarPeloLogin(String login) throws ObjetoInvalidoException, ParametroInvalidoException {
        List<Usuario> usuarios = this.listarUsuarios();
        if(!login.isEmpty()){
            for(Usuario u: usuarios) {
                if(Objects.equals(u.getLogin(), login)) {
                    return u;
                }
            }
            throw new ObjetoInvalidoException();
        }
        else{
            throw new ParametroInvalidoException(login);
        }
    }

    // Adiciona e remove as listas do usuário
    public void adicionarLista(Lista lista) {
        ControladorSessao.getInstancia().getUsuarioOnline().adicionarLista(lista);
    }
    public void removerLista(Lista lista) {
        ControladorSessao.getInstancia().getUsuarioOnline().removerLista(lista);
    }
}
