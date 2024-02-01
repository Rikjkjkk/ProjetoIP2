package PROJETO.fxml;

import java.io.IOException;

import PROJETO.ReviewRestaurante.Modelo.Usuario;
import PROJETO.ReviewRestaurante.Negocio.GerenciadorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaPerfilController {
	// atributos elementos gráficos
	@FXML private Label lblNome;
	@FXML private Label lblLogin;
	@FXML private Label lblTipo;
	@FXML private Button btnVoltar;
	@FXML private Button btnAvaliacoes;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	
	@FXML
	private void initialize() throws IOException {
		ExibirUsuario();
	}
	
	public void ExibirUsuario()throws IOException {
		// Exibe as informações do Usuário Logado		
		Usuario usuarioLogado = sessao.getUsuarioOnline();
		
		String nome = usuarioLogado.getNome();
		String login = usuarioLogado.getLogin();
		String tipo = (String) usuarioLogado.getTipo().toString();
		
		lblNome.setText(nome);
		lblLogin.setText(login);
		lblTipo.setText(tipo);
	}
	
	// Voltar para Tela Principal
	public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
		String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();
				
		if(tipoUsuario == "ADMIN") {
			controladorCenas.TrocarTelaPrincipalAdm(event);
		}
		else{
			controladorCenas.TrocarTelaPrincipal(event);
		}
	}

}