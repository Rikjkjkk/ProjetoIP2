package PROJETO.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Modelo.*;
import PROJETO.ReviewRestaurante.Negocio.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TelaOpiniaoController implements Initializable{
	@FXML private Button btnSubmeter;
	@FXML private Label lblRestaurante;
	@FXML private TextField txtfNota;
	@FXML private TextArea txtaAvaliacao;
	@FXML private Button btnVoltar;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
	Usuario usuarioLogado = sessao.getUsuarioOnline();
	Restaurante restauranteEscolhido = sessao.getRestauranteTemp();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		lblRestaurante.setText(restauranteEscolhido.getNome());
    }
	
	public void Submeter(ActionEvent event) throws ObjetoJaExisteException, IOException
	{
		String comentario = txtaAvaliacao.getText();
		Double a =	Double.parseDouble(txtfNota.getText());
		Avaliacao avaliacao = new Avaliacao(usuarioLogado, restauranteEscolhido, comentario, a);
		
		controladorAvaliacao.adicionarAvaliacao(avaliacao);
		
		txtfNota.setText(null);
		txtaAvaliacao.setText(null);
	}
	
	// Volta pra Tela do Restaurante Escolhido
		public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
			controladorCenas.TrocarTelaRestaurante(event);
		}

}
