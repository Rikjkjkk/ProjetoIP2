package br.ufrpe.projetoip2.negocio;

import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.Usuario;

public class ControladorSessao {
    private static final ControladorSessao instancia = new ControladorSessao();
    private Usuario usuario;
    private Restaurante restauranteTemp;
    private Usuario usuarioTemp;

    // Pega a instância da sessão
    public static ControladorSessao getInstancia() {
        return instancia;
    }

    // Abre a sessão com o usuário informado
    public void abrirSessao(Usuario usuario) {
        this.usuario = usuario;
    }

    // Retorna o usuário que está logado no sistema
    public Usuario getUsuarioOnline() {
        return usuario;
    }

    // Desloga o usuário do sistema
    public void encerrarSessao() {
        this.usuario = null;
    }

    public Restaurante getRestauranteTemp() {
        return restauranteTemp;
    }

    public void setRestauranteTemp(Restaurante restaurante) {
        this.restauranteTemp = restaurante;
    }

    public Usuario getUsuarioTemp() {
        return usuarioTemp;
    }

    public void setUsuarioTemp(Usuario usuario) {
        this.usuarioTemp = usuario;
    }
}