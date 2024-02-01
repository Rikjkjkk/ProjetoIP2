package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TelaPerfilController {
    // atributos elementos gráficos
    @FXML private Label lblNome;
    @FXML private Label lblLogin;
    @FXML private Label lblTipo;
    @FXML private Button btnVoltar;
    @FXML private Button btnAvaliacoes;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    @FXML
    private void initialize() throws IOException {
        ExibirUsuario();
    }

    public void ExibirUsuario()throws IOException {
        // Exibe as informações do Usuário Logado
        Usuario usuarioLogado = sessao.getUsuarioOnline();

        String nome = usuarioLogado.getNome();
        String login = usuarioLogado.getLogin();
        String tipo = (String) usuarioLogado.getTipo().toString();

        lblNome.setText(nome);
        lblLogin.setText(login);
        lblTipo.setText(tipo);
    }

    // Voltar para Tela Principal
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

        if(tipoUsuario == TipoDeConta.ADMIN.toString()) {
            controladorCenas.TrocarTelaPrincipalAdm(event);
        }
        else{
            controladorCenas.TrocarTelaPrincipal(event);
        }
    }

    // Ir para tela minhas avaliações
    public void TrocarTelaMinhasAvaliacoes(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaMinhasAvaliacoes(event);
    }
}
