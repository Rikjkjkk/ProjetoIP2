package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Avaliacao;
import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;
import br.ufrpe.projetoip2.negocio.ControladorAvaliacao;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaOpiniaoController{
    @FXML
    private Button btnSubmeter;
    @FXML private Label lblRestaurante;
    @FXML private TextField txtfNota;
    @FXML private TextArea txtaAvaliacao;
    @FXML private Button btnVoltar;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();
    ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
    Usuario usuarioLogado = sessao.getUsuarioOnline();
    Restaurante restauranteEscolhido = sessao.getRestauranteTemp();

    public void initialize(URL arg0, ResourceBundle arg1) {
        lblRestaurante.setText(restauranteEscolhido.getNome());
    }

    public void Submeter(ActionEvent event) throws ObjetoJaExisteException, IOException, ObjetoInvalidoException {
        String comentario = txtaAvaliacao.getText();
        Double a =	Double.parseDouble(txtfNota.getText());
        Avaliacao avaliacao = new Avaliacao(usuarioLogado, restauranteEscolhido, comentario, a);

        controladorAvaliacao.adicionarAvaliacao(avaliacao);

        txtfNota.setText(null);
        txtaAvaliacao.setText(null);
    }

    // Volta pra Tela do Filme Escolhido
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaRestaurante(event);
    }

}
