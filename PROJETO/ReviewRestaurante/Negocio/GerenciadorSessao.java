package PROJETO.ReviewRestaurante.Negocio;

import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.Usuario;

public class GerenciadorSessao {
    private static final GerenciadorSessao instancia = new GerenciadorSessao();
    private Usuario usuario;
    private Restaurante restauranteTemp;
    private Usuario usuarioTemp;

    public static GerenciadorSessao getInstancia() {
        return instancia;
    }

    public void abrirSessao(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioOnline() {
        return usuario;
    }

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
