package PROJETO.ReviewRestaurante.Negocio;

import java.util.ArrayList;
import java.util.List;

import PROJETO.ReviewRestaurante.Dados.IRepositorioGenerico;
import PROJETO.ReviewRestaurante.Dados.RepositorioGenerico;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Modelo.Avaliacao;
import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.Usuario;

public class ControladorAvaliacao {

    private IRepositorioGenerico<Avaliacao> repositorioAvaliacoes;

    private static ControladorAvaliacao instancia;

    private ControladorAvaliacao() {
        this.repositorioAvaliacoes = new RepositorioGenerico<>("avaliacoes.dat");
    }

    public static ControladorAvaliacao getInstancia() {
        if (instancia == null) {
            instancia = new ControladorAvaliacao();
        }
        return instancia;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) throws ObjetoJaExisteException {
        repositorioAvaliacoes.adicionar(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return repositorioAvaliacoes.listar();
    }

    public void removerAvaliacao(Avaliacao avaliacao) throws ObjetoInvalidoException {
        repositorioAvaliacoes.remover(avaliacao);
    }

    public void editarAvaliacao(Avaliacao avaliacao, Avaliacao nova) throws ObjetoInvalidoException {
        repositorioAvaliacoes.editar(avaliacao, nova);
    }

    public List<Avaliacao> buscarAvaliacoes(Object T) throws ObjetoInvalidoException{
        List<Avaliacao> avaliacoes = this.listarAvaliacoes();
        if (T instanceof Usuario) {
            Usuario usuario = (Usuario) T;
            List<Avaliacao> resultados = new ArrayList<>();
            for (Avaliacao avaliacao : avaliacoes) {
                if (avaliacao.getUsuario().equals(usuario)) {
                    resultados.add(avaliacao);
                }
            }
            return resultados;
        }
        else if (T instanceof Restaurante) {
            Restaurante restaurante = (Restaurante) T;
            List<Avaliacao> resultados = new ArrayList<>();
            for (Avaliacao avaliacao : avaliacoes) {
                if (avaliacao.getRestaurante().equals(restaurante)) {
                    resultados.add(avaliacao);
                }
            }
            return resultados;   
        }
        else {
            throw new ObjetoInvalidoException();
        }
    }
    
}
