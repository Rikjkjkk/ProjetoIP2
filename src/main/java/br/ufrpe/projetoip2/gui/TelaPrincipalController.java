package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class TelaPrincipalController {
    @FXML private Button btnPerfil;
    @FXML private Button btnListas;
    @FXML private Button btnLogoff;
    @FXML private Button btnPesquisaRestaurante;
    @FXML private Button btnPesquisaUsuario;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    @FXML
    private void initialize() {
    }

    // Volta pra Tela de Login, Deslogando da sessão
    public void Logoff(ActionEvent event) throws IOException {
        sessao.encerrarSessao();
        controladorCenas.TrocarTelaLogin(event);
    }

    // Ir para a tela de Minhas Listas
    public void TrocarTelaListas(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaListas(event);
    }

    // Ir para Tela de Meu Perfil
    public void TrocarTelaPerfil(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaPerfil(event);
    }

    public void PesquisaRestaurante(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaRestaurante(event);
    }

    public void PesquisaUsuario(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaUsuario(event);
    }
}
