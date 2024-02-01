package PROJETO.fxml;

import java.io.IOException;
import java.time.LocalDate;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.TipoComida;
import PROJETO.ReviewRestaurante.Negocio.ControladorRestaurante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TelaAdicionarRestauranteController {
	// Atributos elementos gráficos
		@FXML private TextField txtNome;
		@FXML private TextField txtTipoComida;
		@FXML private TextField txtDescricao;
		@FXML private DatePicker dataSelect;
		@FXML private Button btnVoltar;
		@FXML private Button btnAdicionar;
		
		ControladorCenas controladorCenas = ControladorCenas.getInstance();
		
		public void AdicionarNovoFilme(ActionEvent event)throws IOException, ObjetoJaExisteException {
			// Adicionar novo Restaurante
			ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();
			String nome = txtNome.getText();
			String tipoString = txtTipoComida.getText();
			TipoComida tipoComida = TipoComida.valueOf(tipoString);
			String descricao = txtDescricao.getText();
			
			Restaurante restaurante = new Restaurante(nome, tipoComida, descricao);
			controladorRestaurante.adicionarRestaurante(restaurante);	
			
			// Zerar os TxtFields
			txtNome.setText(null);
			txtTipoComida.setText(null);
			txtDescricao.setText(null);
		}
		
		// Ir para Tela Principal do ADM
		public void TrocarTelaPrincipalAdm(ActionEvent event) throws IOException {
			controladorCenas.TrocarTelaPrincipalAdm(event);
		}
}