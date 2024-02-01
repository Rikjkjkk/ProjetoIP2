package PROJETO.fxml;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaInicialController {
	// atributos elementos gráficos
		@FXML private Button btnLogin;
		@FXML private Button btnCadastro;
		
		ControladorCenas controladorCenas = ControladorCenas.getInstance();
		
		// Ir para Login
		public void TelaLogin(ActionEvent event) throws IOException {					
			controladorCenas.TrocarTelaLogin(event);
		}
		
		// Ir para Cadastro
		public void TelaCadastro(ActionEvent event) throws IOException {
			controladorCenas.TrocarTelaCadastro(event);
		}
}
