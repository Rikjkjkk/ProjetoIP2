package PROJETO.ReviewRestaurante.Negocio;

import java.util.ArrayList;
import java.util.List;

import PROJETO.ReviewRestaurante.Dados.IRepositorioGenerico;
import PROJETO.ReviewRestaurante.Dados.RepositorioGenerico;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Exceptions.SenhaErradaException;
import PROJETO.ReviewRestaurante.Modelo.Lista;
import PROJETO.ReviewRestaurante.Modelo.TipoDeConta;
import PROJETO.ReviewRestaurante.Modelo.Usuario;

public class ControladorUsuario {
    private IRepositorioGenerico<Usuario> repositorioUsuarios;
    
    private static ControladorUsuario instancia;

    private ControladorUsuario() {
        this.repositorioUsuarios = new RepositorioGenerico<>("usuarios.dat");
    }
    
    public static ControladorUsuario getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }

    public boolean login(String login, String senha) throws SenhaErradaException, ObjetoInvalidoException {
        List<Usuario> usuarios = this.listarUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                if (usuario.getSenha().equals(senha)) {
                    GerenciadorSessao.getInstancia().abrirSessao(usuario);
                    return true;
                }
                else {
                    throw new SenhaErradaException();
                }
            }            
        }
        throw new ObjetoInvalidoException(login);
    }

    public void logoff() {
        GerenciadorSessao.getInstancia().encerrarSessao();
    }

    public Usuario getUsuario() {
        return instancia.getUsuario();
    }

    public void adicionarUsuario(Usuario usuario) throws ObjetoJaExisteException {
        repositorioUsuarios.adicionar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuarios.listar();
    }

    public void removerUsuario(Usuario usuario) throws ObjetoInvalidoException {
        repositorioUsuarios.remover(usuario);
    }

    public void editarUsuario(Usuario usuario, Usuario novo) throws ObjetoInvalidoException {
        repositorioUsuarios.editar(usuario, novo);
    }

    public List<Usuario> buscarUsuario(Object T) throws ObjetoInvalidoException {
        List<Usuario> usuarios = this.listarUsuarios();
        if (T instanceof String) {
            String palavra = (String) T;
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
        else if (T instanceof TipoDeConta) {
            TipoDeConta tipo = (TipoDeConta) T;
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
    
    public Usuario buscarUmUsuario(String login) throws ObjetoInvalidoException {
        List<Usuario> usuarios = this.listarUsuarios();
       for(Usuario f: usuarios) {
    	   if(f.getLogin() == login) {
    		   return f;
    	   }
        }
       return null;
    }

    public void adicionarLista(Lista lista) {
        GerenciadorSessao.getInstancia().getUsuarioOnline().adicionarLista(lista);
    }
    public void removerLista(Lista lista) {
        GerenciadorSessao.getInstancia().getUsuarioOnline().removerLista(lista);
    }

}
