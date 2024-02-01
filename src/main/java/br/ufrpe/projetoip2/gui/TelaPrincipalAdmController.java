package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class TelaPrincipalAdmController {
    @FXML private Button btnAdicionarRestaurante;
    @FXML private Button btnCadastrarUsuario;
    @FXML private Button btnPerfil;
    @FXML private Button btnPesquisaRestaurante;
    @FXML private Button btnPesquisaUsuario;
    @FXML private Button btnPesuisaAvaliacoes;

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

    // Ir para Tela de Adcionar um Restaurante
    public void TrocarTelaAdcionarRestaurante(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaAdicionarRestaurante(event);
    }

    // Ir para Tela de Cadastrar um Usuário
    public void TrocarTelaCadastroADM(ActionEvent event) throws IOException {
        // Fazer essa tela
    }

    // Ir para a tela de Meu Perfil
    public void TrocarTelaPerfil(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaPerfil(event);
    }

    // Ir para Tela de Pesquisar Restaurantes
    public void PesquisaRestaurante(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaRestaurante(event);
    }

    // Ir para Tela de Pesquisar Usuários
    public void PesquisaUsuario(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaUsuario(event);
    }

    // Ir para Tela de Pesquisar Avaliações
    public void PesquisaAvaliacao(ActionEvent event)throws IOException, ObjetoInvalidoException {
        controladorCenas.TrocarPesquisaAvaliacao(event);
    }
}
