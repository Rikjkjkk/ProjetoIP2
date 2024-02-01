package PROJETO.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.TipoComida;
import PROJETO.ReviewRestaurante.Negocio.ControladorRestaurante;
import PROJETO.ReviewRestaurante.Negocio.GerenciadorSessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPesquisaRestauranteController implements Initializable{
	@FXML private Button btnVoltar;
	@FXML private Button btnRestauranteInfo;
	@FXML private Button btnFiltro;
	@FXML private TextField txtfNome;
	
	@FXML private TableView<Restaurante> listaRestaurantesBuscados;
	@FXML private TableColumn<Restaurante, String> nomeRestaurante;
	@FXML private TableColumn<Restaurante, TipoComida> TipoComida;
	@FXML private ObservableList<Restaurante> items = FXCollections.observableArrayList();
	@FXML private PropertyValueFactory<Restaurante, ?> propriedadeValorFabrica;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();
	
	Restaurante restauranteEscolhido;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		List<Restaurante> resultadoBusca = controladorRestaurante.listarRestaurantes();
		for(Restaurante f : resultadoBusca) {
			items.add(f);
		}
		
		nomeRestaurante.setCellValueFactory(new PropertyValueFactory<Restaurante, String>("nome"));      
        TipoComida.setCellValueFactory(new PropertyValueFactory<Restaurante, TipoComida>("tipo de comida"));
      
        listaRestaurantesBuscados.setItems(items);
    }
	
	public void FiltrarPesquisa() throws ObjetoInvalidoException{
		String nomeRestaurante = txtfNome.getText();
		
		// Limpa todos os itens da lista
	    listaRestaurantesBuscados.getItems().clear();
		
		List<Restaurante> resultadoBusca = controladorRestaurante.buscarRestaurantes(nomeRestaurante);
		for(Restaurante f : resultadoBusca) {
			items.add(f);
		}
		listaRestaurantesBuscados.setItems(items);
	}
	
	public void VerInfoRestaurante(ActionEvent event) throws ObjetoInvalidoException, IOException {
		String nomeRestaurante = txtfNome.getText();
		
		List<Restaurante> resultadoBusca = controladorRestaurante.buscarRestaurantes(nomeRestaurante);
		for(Restaurante f : resultadoBusca) {
			sessao.setRestauranteTemp(f);
		}
		
		controladorCenas.TrocarTelaRestaurante(event);
	}
	
	// Volta pra Tela Principal
	public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
		listaRestaurantesBuscados.setItems(null);
		String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();
			
		if(tipoUsuario == "ADMIN") {
			controladorCenas.TrocarTelaPrincipalAdm(event);
		}
		else{
			controladorCenas.TrocarTelaPrincipal(event);
		}
	}
}
