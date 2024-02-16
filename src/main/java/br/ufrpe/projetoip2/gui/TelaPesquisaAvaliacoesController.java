package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Avaliacao;
import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.negocio.ControladorAvaliacao;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class TelaPesquisaAvaliacoesController{
    @FXML
    private Button btnVoltar;
    @FXML private Button btnFiltro;
    @FXML private TextField txtfNome;

    @FXML private TableView<Avaliacao> listaAvaliacoesBuscadas;
    @FXML private TableColumn<Avaliacao, LocalDate> dataFeita;
    @FXML private TableColumn<Avaliacao, Usuario> nomeUsuario;
    @FXML private TableColumn<Avaliacao, Restaurante> nomeRestaurante;
    @FXML private TableColumn<Avaliacao, Double> nota;
    @FXML private ObservableList<Avaliacao> items = FXCollections.observableArrayList();
    @FXML private PropertyValueFactory<Avaliacao, ?> propriedadeValorFabrica;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();
    ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();

    Avaliacao avaliacaoEscolhida;

    public void initialize(URL arg0, ResourceBundle arg1) {
        listaAvaliacoesBuscadas.getItems().clear();
        List<Avaliacao> resultadoBusca = controladorAvaliacao.listarAvaliacoes();
        for(Avaliacao a : resultadoBusca) {
            items.add(a);
        }

        dataFeita.setCellValueFactory(new PropertyValueFactory<Avaliacao, LocalDate>("data"));
        nomeUsuario.setCellValueFactory(new PropertyValueFactory<Avaliacao, Usuario>("usuario"));
        nomeRestaurante.setCellValueFactory(new PropertyValueFactory<Avaliacao, Restaurante>("filme"));
        nota.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("nota"));

        listaAvaliacoesBuscadas.setItems(items);
    }

    public void FiltrarPesquisa() throws ObjetoInvalidoException {
        String nomeAvaliacao = txtfNome.getText();

        // Limpa todos os itens da lista
        listaAvaliacoesBuscadas.getItems().clear();

        List<Avaliacao> resultadoBusca = controladorAvaliacao.buscarAvaliacoes(nomeAvaliacao);
        for(Avaliacao a : resultadoBusca) {
            items.add(a);
        }
        listaAvaliacoesBuscadas.setItems(items);
    }


    // Volta pra Tela Principal
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        listaAvaliacoesBuscadas.setItems(null);
        String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

        if(tipoUsuario == "ADMIN") {
            controladorCenas.TrocarTelaPrincipalAdm(event);
        }
        else{
            controladorCenas.TrocarTelaPrincipal(event);
        }
    }
}
