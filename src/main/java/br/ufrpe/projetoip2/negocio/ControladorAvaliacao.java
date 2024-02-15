package br.ufrpe.projetoip2.negocio;

import br.ufrpe.projetoip2.beans.Avaliacao;
import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.dados.IRepositorioAvaliacao;
import br.ufrpe.projetoip2.dados.IRepositorioGenerico;
import br.ufrpe.projetoip2.dados.RepositorioAvaliacao;
import br.ufrpe.projetoip2.dados.RepositorioGenerico;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;

import java.util.ArrayList;
import java.util.List;

public class ControladorAvaliacao {
    private final IRepositorioAvaliacao repositorioAvaliacoes;
    private static ControladorAvaliacao instancia;
    ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();

    // Controlador
    public ControladorAvaliacao() {
        this.repositorioAvaliacoes = new RepositorioAvaliacao();
    }

    // Pega a instância do controlador
    public static ControladorAvaliacao getInstancia() {
        if (instancia == null) {
            instancia = new ControladorAvaliacao();
        }
        return instancia;
    }

    // CRUD
    public void adicionarAvaliacao(Avaliacao avaliacao) throws ObjetoJaExisteException, ObjetoInvalidoException {
        if (avaliacao != null){
            if(avaliacao.getUsuario() != null && avaliacao.getRestaurante() != null && avaliacao.getComentario() != null && avaliacao.getNota() != 0 && avaliacao.getDataAvaliacao() != null){
                Restaurante restaurante = avaliacao.getRestaurante();
                for(Restaurante f : controladorRestaurante.listarRestaurantes()){
                    if (f.equals(restaurante)){
                        if(avaliacao.getUsuario().equals(TipoDeConta.PADRAO) || avaliacao.getUsuario().equals(TipoDeConta.ADMIN) ){
                            f.getAvaliacoesPublico().add(avaliacao);
                            controladorRestaurante.calcularMediaNotas(f);
                        }
                        else if(avaliacao.getUsuario().equals(TipoDeConta.CRITICO)){
                            f.getAvaliacoesCriticos().add(avaliacao);
                            controladorRestaurante.calcularMediaNotas(f);
                        }
                    }
                }
                repositorioAvaliacoes.adicionar(avaliacao);
            }
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public List<Avaliacao> listarAvaliacoes() {
        return repositorioAvaliacoes.listar();
    }

    public void removerAvaliacao(Avaliacao avaliacao) throws ObjetoInvalidoException {
        if (avaliacao != null){
            repositorioAvaliacoes.remover(avaliacao);
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public void editarAvaliacao(Avaliacao avaliacao, Avaliacao nova) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if(!listarAvaliacoes().contains(nova)){
            if (avaliacao != null && nova != null){
                if(nova.getUsuario() != null && nova.getRestaurante() != null && nova.getComentario() != null && nova.getNota() != 0 && nova.getDataAvaliacao() != null){
                    repositorioAvaliacoes.editar(avaliacao, nova);
                }
            }
            else {
                throw new ObjetoInvalidoException(avaliacao);
            }
        }
        else{
            throw new ObjetoJaExisteException(nova);
        }
    }

    // Buscar uma avaliação passando ela como parâmetro
    public List<Avaliacao> buscarAvaliacoes(Object T) throws ObjetoInvalidoException{
        List<Avaliacao> avaliacoes = this.listarAvaliacoes();
        if (T instanceof Usuario usuario) {
            List<Avaliacao> resultados = new ArrayList<>();
            for (Avaliacao avaliacao : avaliacoes) {
                if (avaliacao.getUsuario().equals(usuario)) {
                    resultados.add(avaliacao);
                }
            }
            return resultados;
        }
        else if (T instanceof Restaurante restaurante) {
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
