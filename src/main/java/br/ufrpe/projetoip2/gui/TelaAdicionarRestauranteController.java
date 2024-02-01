package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.TipoComida;
import br.ufrpe.projetoip2.exception.CamposNaoPreenchidosException;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;
import br.ufrpe.projetoip2.negocio.ControladorRestaurante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TelaAdicionarRestauranteController implements Initializable {
    // Atributos elementos gráficos
    @FXML private TextField txtNome;
    @FXML private ComboBox<TipoComida> cbTipoComida = new ComboBox<>();
    @FXML private TextArea txaDescricao;

    @FXML private Label lblErro;
    @FXML private Label lblSucess;
    @FXML private Button btnVoltar;
    @FXML private Button btnAdicionar;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    @FXML
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbTipoComida.getItems().addAll(Arrays.asList(TipoComida.values()));
    }

    // Limpa o label de erro
    public void initialize() {
        // Configurar ouvintes de foco para cada campo
        txtNome.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });

        cbTipoComida.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });

        txaDescricao.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
                lblSucess.setText(""); // Limpar a mensagem de sucesso
            }
        });
    }

    public void AdicionarNovoRestaurante(ActionEvent event) throws IOException, ObjetoJaExisteException, ObjetoInvalidoException {
        try {
            // Adicionar novo Restaurante
            ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();
            String nome = txtNome.getText();
            TipoComida tipoComida = cbTipoComida.getValue();
            String descricao = txaDescricao.getText();

            // Verifica se os Campos da Interface estão vazios
            if (nome.isEmpty() || tipoComida == null || descricao.isEmpty()) {
                throw new CamposNaoPreenchidosException("Por favor, preencha todos os campos.");
            }

            Restaurante restaurante = new Restaurante(nome, tipoComida, descricao);
            controladorRestaurante.adicionarRestaurante(restaurante);

            // Zerar os TxtFields
            txtNome.setText(null);
            txaDescricao.setText(null);
            cbTipoComida.setValue(null);

            this.lblSucess.setText("Restaurante adicionado ao sistema!");
        } catch (CamposNaoPreenchidosException e) {
            this.lblErro.setText("Erro: " + e.getMessage());
        } catch (ObjetoJaExisteException e) {
            this.lblErro.setText("Erro: Este restaurante já existe no sistema");
        } catch (ObjetoInvalidoException e) {
            this.lblErro.setText("Erro: Este restaurante é inválido");
        }

    }

    // Volta pra Tela de Pesquisa de Restaurantes
    public void TrocarTelaPesquisaRestaurante(ActionEvent event) throws IOException {
        controladorCenas.TrocarPesquisaRestaurante(event);
    }
}
