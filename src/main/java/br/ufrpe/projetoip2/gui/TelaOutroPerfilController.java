package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TelaOutroPerfilController {

    // atributos elementos gráficos
    @FXML
    private Label lNome;
    @FXML private Label lLogin;
    @FXML private Label lTipo;
    @FXML private Button btnVoltar;
    @FXML private Button btnAvaliacoes;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    @FXML
    private void initialize() throws IOException {
        ExibirUsuario();
    }

    @FXML
    private void ExibirUsuario() throws IOException {
        Usuario usuarioVisitado = sessao.getUsuarioTemp();

        String nome = usuarioVisitado.getNome();
        String login = usuarioVisitado.getLogin();
        String tipo = (String) usuarioVisitado.getTipo().toString();

        lNome.setText(nome);
        lLogin.setText(login);
        lTipo.setText(tipo);
    }

    // Voltar para Tela Principal
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

        if(tipoUsuario == "ADMIN") {
            controladorCenas.TrocarTelaPrincipalAdm(event);
        }
        else{
            controladorCenas.TrocarTelaPrincipal(event);
        }
    }
    public void TrocarOutrasAvaliacoes(ActionEvent event) throws IOException {
        controladorCenas.TrocarOutrasAvaliacoes(event);
    }

}
