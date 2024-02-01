package PROJETO.fxml;

import java.io.IOException;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Exceptions.SenhaErradaException;
import PROJETO.ReviewRestaurante.Negocio.ControladorUsuario;
import PROJETO.ReviewRestaurante.Negocio.GerenciadorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class TelaLoginController {

		// atributos elementos gráficos
		@FXML private TextField txtSenha;
		@FXML private TextField txtLogin;
		@FXML private Button btnVoltar;
		@FXML private Button btnLogin;
		@FXML private Label lblErro;
		
		ControladorCenas controladorCenas = ControladorCenas.getInstance();
		GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
		
		// Ir para Tela Inicial
		public void TelaInicial(ActionEvent event) throws IOException {
			controladorCenas.TrocarTelaInicial(event);
		}		
		
		// Pega os dados informados nas Boxes, chama a função de login, se verdadeira, Passa pra tela Principal
		public void FazerLogin(ActionEvent event) throws IOException, SenhaErradaException, ObjetoInvalidoException {
			ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
			
			String login = txtLogin.getText();
			String senha = txtSenha.getText();
			
			if (controladorUsuario.login(login, senha)) {
				String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();
				
				if(tipoUsuario == "ADMIN") {
					controladorCenas.TrocarTelaPrincipalAdm(event);
				}
				else{
					controladorCenas.TrocarTelaPrincipal(event);
				}
			}
			else {
				lblErro.setText("Usuário não existe ou não encontrado");
			}
		}
		
}