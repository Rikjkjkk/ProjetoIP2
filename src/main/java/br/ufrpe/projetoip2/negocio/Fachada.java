package br.ufrpe.projetoip2.negocio;

import br.ufrpe.projetoip2.beans.Avaliacao;
import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;

import java.util.List;

public class Fachada {
    private static final ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
    private static final ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();
    private static final ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
    private static final ControladorSessao controladorSessao = ControladorSessao.getInstancia();

    // Métodos do ControladorAvaliações
    public void adicionarAvaliacao(Avaliacao avaliacao) throws ObjetoJaExisteException, ObjetoInvalidoException {
        controladorAvaliacao.adicionarAvaliacao(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return controladorAvaliacao.listarAvaliacoes();
    }

    public void removerAvaliacao(Avaliacao avaliacao) throws ObjetoInvalidoException {
        controladorAvaliacao.removerAvaliacao(avaliacao);
    }

    // Métodos do ControladorRestaurantes
    public void adicionarRestaurante(Restaurante restaurante) throws ObjetoInvalidoException, ObjetoJaExisteException {
        controladorRestaurante.adicionarRestaurante(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        return controladorRestaurante.listarRestaurantes();
    }

    public void removerRestaurante(Restaurante restaurante) throws ObjetoInvalidoException {
        controladorRestaurante.removerRestaurante(restaurante);
    }

    // Métodos da fachada para usuários
    public void adicionarUsuario(Usuario usuario) throws ObjetoJaExisteException, ObjetoInvalidoException {
        controladorUsuario.adicionarUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return controladorUsuario.listarUsuarios();
    }

    public void removerUsuario(Usuario usuario) throws ObjetoInvalidoException {
        controladorUsuario.removerUsuario(usuario);
    }

    // Métodos do ControladorSessão
    public void abrirSessao(Usuario usuario) {
        controladorSessao.abrirSessao(usuario);
    }

    public Usuario getUsuarioOnline() {
        return controladorSessao.getUsuarioOnline();
    }

    public void encerrarSessao() {
        controladorSessao.encerrarSessao();
    }

    public Restaurante getRestauranteTemp() {
        return controladorSessao.getRestauranteTemp();
    }

    public void setRestauranteTemp(Restaurante restaurante) {
        controladorSessao.setRestauranteTemp(restaurante);
    }

    public Usuario getUsuarioTemp() {
        return controladorSessao.getUsuarioTemp();
    }

    public void setUsuarioTemp(Usuario usuario) {
        controladorSessao.setUsuarioTemp(usuario);
    }

}