package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import br.ufrpe.projetoip2.negocio.ControladorUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaPesquisaUsuarioController implements Initializable {
    @FXML private Button btnVoltar;
    @FXML private Button btnUsuarioInfo;
    @FXML private Button btnFiltro;
    @FXML private TextField txtfNome;

    @FXML private TableView<Usuario> listaUsuariosBuscados;
    @FXML private TableColumn<Usuario, String> nomeUsuario;
    @FXML private TableColumn<Usuario, String> login;
    @FXML private TableColumn<Usuario, String> tipo;
    @FXML private final ObservableList<Usuario> items = FXCollections.observableArrayList();

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();
    ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<Usuario> resultadoBusca = controladorUsuario.listarUsuarios();
        items.addAll(resultadoBusca);

        nomeUsuario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
        login.setCellValueFactory(new PropertyValueFactory<Usuario, String>("login"));
        tipo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("tipo"));

        listaUsuariosBuscados.setItems(items);
    }

    public void FiltrarPesquisa() throws ObjetoInvalidoException {
        String nomeUsuario = txtfNome.getText();

        // Limpa todos os itens da lista
        listaUsuariosBuscados.getItems().clear();

        List<Usuario> resultadoBusca = controladorUsuario.buscarUsuario(nomeUsuario);
        items.addAll(resultadoBusca);
        listaUsuariosBuscados.setItems(items);
    }

    // Pega o objeto selecionado no TableView e usa ele pra ir para suas informações
    public void VerInfoUsuario(ActionEvent event) throws IOException {
        TableSelectionModel<Usuario> selectionModel = listaUsuariosBuscados.getSelectionModel();
        Usuario usuarioSelecionado = selectionModel.getSelectedItem(); // Obtém o Restaurante selecionado

        if (usuarioSelecionado != null) {
            sessao.setUsuarioTemp(usuarioSelecionado); // Define o restaurante selecionado como restaurante temporário
            controladorCenas.TrocarOutroUsuario(event); // Navega para a TelaRestaurante
        }
    }

    // Volta pra Tela Principal
    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        listaUsuariosBuscados.setItems(null);
        String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

        if(tipoUsuario == TipoDeConta.ADMIN.toString()) {
            controladorCenas.TrocarTelaPrincipalAdm(event);
        }
        else{
            controladorCenas.TrocarTelaPrincipal(event);
        }
    }
}
