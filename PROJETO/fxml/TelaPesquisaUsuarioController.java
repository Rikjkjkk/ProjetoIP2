package PROJETO.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Modelo.Usuario;
import PROJETO.ReviewRestaurante.Negocio.ControladorUsuario;
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

public class TelaPesquisaUsuarioController implements Initializable{
	@FXML private Button btnVoltar;
	@FXML private Button btnUsuario;
	@FXML private Button btnFiltro;
	@FXML private TextField txtfNome;
	
	@FXML private TableView<Usuario> listaUsuariosBuscados;
	@FXML private TableColumn<Usuario, String> nomeUsuario;
	@FXML private TableColumn<Usuario, String> loginUsuario;
	@FXML private ObservableList<Usuario> items = FXCollections.observableArrayList();
	@FXML private PropertyValueFactory<Usuario, ?> propriedadeValorFabrica;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
	
	Usuario UsuarioEscolhido;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		listaUsuariosBuscados.getItems().clear();
		List<Usuario> resultadoBusca = controladorUsuario.listarUsuarios();
		for(Usuario f : resultadoBusca) {
			items.add(f);
		}
		
		nomeUsuario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));      
        loginUsuario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("login"));
        
        listaUsuariosBuscados.setItems(items);
    }
	
	public void FiltrarPesquisa() throws ObjetoInvalidoException{
		String nome = txtfNome.getText();
		
		// Limpa todos os itens da lista
	    listaUsuariosBuscados.getItems().clear();
		
		List<Usuario> resultadoBusca = controladorUsuario.buscarUsuario(nome);
		for(Usuario f : resultadoBusca) {
			items.add(f);
		}
		listaUsuariosBuscados.setItems(items);
	}
	
	// Volta pra Tela Principal
		public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
			listaUsuariosBuscados.setItems(null);
			String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();
			
			if(tipoUsuario == "ADMIN") {
				controladorCenas.TrocarTelaPrincipalAdm(event);
			}
			else{
				controladorCenas.TrocarTelaPrincipal(event);
			}
		}
		
	// Visitar Perfil de outro usuário.
		public void TrocarTelaOutroUsuario(ActionEvent event) throws ObjetoInvalidoException, IOException {
			String nomeUsuario = txtfNome.getText();
			
			List<Usuario> resultadoBusca = controladorUsuario.buscarUsuario(nomeUsuario);
			for(Usuario f : resultadoBusca) {
				sessao.setUsuarioTemp(f);
			}
			
			controladorCenas.TrocarOutroUsuario(event);
		}
		}
		