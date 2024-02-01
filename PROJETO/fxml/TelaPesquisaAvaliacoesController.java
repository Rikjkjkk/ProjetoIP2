package PROJETO.fxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Modelo.Avaliacao;
import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.Usuario;
import PROJETO.ReviewRestaurante.Negocio.ControladorAvaliacao;
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

public class TelaPesquisaAvaliacoesController implements Initializable{
	@FXML private Button btnVoltar;
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
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
	
	Avaliacao avaliacaoEscolhida;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		listaAvaliacoesBuscadas.getItems().clear();
		List<Avaliacao> resultadoBusca = controladorAvaliacao.listarAvaliacoes();
		for(Avaliacao a : resultadoBusca) {
			items.add(a);
		}
		
		dataFeita.setCellValueFactory(new PropertyValueFactory<Avaliacao, LocalDate>("data"));      
		nomeUsuario.setCellValueFactory(new PropertyValueFactory<Avaliacao, Usuario>("usuario"));
		nomeRestaurante.setCellValueFactory(new PropertyValueFactory<Avaliacao, Restaurante>("restaurante"));
		nota.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("nota"));
      
		listaAvaliacoesBuscadas.setItems(items);
    }
	
	public void FiltrarPesquisa() throws ObjetoInvalidoException{
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