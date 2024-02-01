package PROJETO.fxml;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Modelo.Usuario;
import PROJETO.ReviewRestaurante.Negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class TelaCadastroController {
	
	// Atributos elementos gráficos
	@FXML private TextField txtNome;
	@FXML private TextField txtSenha;
	@FXML private TextField txtLogin;
	@FXML private Button btnVoltar;
	@FXML private Button btnCadastro;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	
	public void CadastrarNovoUsuario(ActionEvent event)throws IOException, ObjetoJaExisteException {
		// Cadastrar novo usuario
		ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
		String nome = txtNome.getText();
		String senha = txtSenha.getText();
		String login = txtLogin.getText();
		
		Usuario usuario = new Usuario(nome, login, senha);
		controladorUsuario.adicionarUsuario(usuario);	
		
		// Confirmar Cadastro
		controladorCenas.TrocarTelaCadastroRealizado(event);
	}
	
	// Ir para Tela Inicial
	public void TelaInicial(ActionEvent event) throws IOException {
		controladorCenas.TrocarTelaInicial(event);
	}
}