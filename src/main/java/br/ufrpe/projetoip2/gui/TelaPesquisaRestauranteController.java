package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.negocio.ControladorRestaurante;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TelaPesquisaRestauranteController implements Initializable {
    @FXML private Button btnVoltar;
    @FXML private Button btnRestauranteInfo;
    @FXML private Button btnFiltro;
    @FXML private TextField txtfNome;

    @FXML private TableView<Restaurante> listaRestaurantesBuscados;
    @FXML private TableColumn<Restaurante, String> nomeRestaurante;
    @FXML private TableColumn<Restaurante, String> tipoComida;

    @FXML private final ObservableList<Restaurante> items = FXCollections.observableArrayList();

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();
    ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<Restaurante> resultadoBusca = controladorRestaurante.listarRestaurantes();
        items.addAll(resultadoBusca);

        nomeRestaurante.setCellValueFactory(new PropertyValueFactory<Restaurante, String>("nome"));
        tipoComida.setCellValueFactory(new PropertyValueFactory<Restaurante, String>("tipoComida"));

        listaRestaurantesBuscados.setItems(items);
    }

    public void FiltrarPesquisa() throws ObjetoInvalidoException {
        String nomeRestaurante = txtfNome.getText();

        // Limpa todos os itens da lista
        listaRestaurantesBuscados.getItems().clear();

        List<Restaurante> resultadoBusca = controladorRestaurante.buscarRestaurante(nomeRestaurante);
        items.addAll(resultadoBusca);
        listaRestaurantesBuscados.setItems(items);
    }

    // Pega o objeto selecionado no TableView e usa ele pra ir para suas informações
    public void VerInfoRestaurante(ActionEvent event) throws ObjetoInvalidoException, IOException {
        TableSelectionModel<Restaurante> selectionModel = listaRestaurantesBuscados.getSelectionModel();
        Restaurante restauranteSelecionado = selectionModel.getSelectedItem(); // Obtém o restaurante selecionado

        if (restauranteSelecionado != null) {
            sessao.setRestauranteTemp(restauranteSelecionado); // Define o restaurante selecionado como restaurante temporário
            controladorCenas.TrocarTelaRestaurante(event); // Navega para a TelaRestaurante
        }
    }

    // Volta pra Tela Principal
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        listaRestaurantesBuscados.setItems(null);
        String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

        if(tipoUsuario == TipoDeConta.ADMIN.toString()) {
            controladorCenas.TrocarTelaPrincipalAdm(event);
        }
        else{
            controladorCenas.TrocarTelaPrincipal(event);
        }
    }
}