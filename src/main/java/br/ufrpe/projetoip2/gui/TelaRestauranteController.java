package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class TelaRestauranteController {
    // Atributos elementos gráficos
    @FXML private Label lblNome;
    @FXML private Label lblTipoComida;
    @FXML private Label lblNotaP;
    @FXML private Label lblNotaC;
    @FXML private TextArea txaDescricao;
    @FXML private Button btnEscreverAvaliacao;
    @FXML private Button btnVoltar;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    @FXML
    private void initialize() throws IOException {
        ExibirRestaurante();
    }

    public void ExibirRestaurante()throws IOException {
        // Exibe as informações do Restaurante Escolhido
        Restaurante restauranteEscolhido = sessao.getRestauranteTemp();

        String nome = restauranteEscolhido.getNome();
        String tipoComida = restauranteEscolhido.getTipoComida().toString();
        String descricao = restauranteEscolhido.getDescricao();
        String notaP = Double.toString(restauranteEscolhido.getNotaPublico());
        String notaC = Double.toString(restauranteEscolhido.getNotaCriticos());

        lblNome.setText(nome);
        lblTipoComida.setText(tipoComida);
        txaDescricao.setText(descricao);
        lblNotaP.setText(notaP);
        lblNotaC.setText(notaC);
    }

    // Volta pra Tela de Pesquisa de Restaurantes
    public void TrocarTelaPesquisaRestaurante(ActionEvent event) throws IOException {
        controladorCenas.TrocarPesquisaRestaurante(event);
    }

    // Vai pra tela de Submeter Avaliação
    public void TrocarEscreverAvaliacao(ActionEvent event) throws IOException {
        controladorCenas.TrocarEscreverAvaliacao(event);
    }

}
