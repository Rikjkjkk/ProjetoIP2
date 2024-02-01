package PROJETO.fxml;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaCadastroRealizadoController {
	
	@FXML private Button btnVoltar;
	@FXML private Button btnTelaLogin;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	
	// Ir para Tela Inicial
	public void TelaInicial(ActionEvent event) throws IOException {
		controladorCenas.TrocarTelaInicial(event);
	}	
	
	// Ir para Login
	public void TelaLogin(ActionEvent event) throws IOException {					
		controladorCenas.TrocarTelaLogin(event);
	}
}