package PROJETO.fxml;

import java.io.IOException;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Negocio.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPrincipalController {
	
	@FXML private Button btnPerfil;
	@FXML private Button btnListas;
	@FXML private Button btnVoltar;
	@FXML private Button btnPesquisaRestaurante;
	@FXML private Button btnPesquisaUsuario;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	
	@FXML
	private void initialize() {
	}
	
	// Ir para a tela de Minhas Listas
	public void TrocarTelaListas(ActionEvent event) throws IOException {
		controladorCenas.TrocarTelaListas(event);
	}
	
	// Ir para Tela de Meu Perfil
	public void TrocarTelaPerfil(ActionEvent event) throws IOException {
		controladorCenas.TrocarTelaPerfil(event);
	}
	
	// Volta pra Tela de Inicial, Deslogando da sessão
		public void Logoff(ActionEvent event) throws IOException {
			sessao.encerrarSessao();
			controladorCenas.TrocarTelaInicial(event);
		}
	
	public void PesquisaRestaurante(ActionEvent event)throws IOException, ObjetoInvalidoException {
		controladorCenas.TrocarPesquisaRestaurante(event);
	}
	
	public void PesquisaUsuario(ActionEvent event)throws IOException, ObjetoInvalidoException {		
		controladorCenas.TrocarPesquisaUsuario(event);				
	}
}