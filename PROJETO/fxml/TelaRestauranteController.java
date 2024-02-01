package fxml;

import java.io.IOException;

import ReviewRestaurante.Modelo.Restaurante;
import ReviewRestaurante.Negocio.GerenciadorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class TelaRestauranteController {
	// Atributos elementos gráficos
	@FXML private Label lblNome;
	@FXML private Label lblTipoComida;
	@FXML private Label lblNota;
	@FXML private Label lblNotaP;
	@FXML private Label lblNotaC;
	@FXML private Label lblDescricao;
	@FXML private Button btnEscreverAvaliacao;
	@FXML private Button btnVoltar;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	
	@FXML
	private void initialize() throws IOException {
		ExibirRestaurante();
	}
	
	public void ExibirRestaurante()throws IOException {
		// Exibe as informações do Restaurante Escolhido
		Restaurante restauranteEscolhido = sessao.getRestauranteTemp();
		
		String nome = restauranteEscolhido.getNome();
		String tipoComida = restauranteEscolhido.getTipoComida().toString();
		String descricao = restauranteEscolhido.getDescricao();
		String notaP = Double.toString(restauranteEscolhido.getNotaPublico());
		String notaC = Double.toString(restauranteEscolhido.getNotaCriticos());
		
		lblNome.setText(nome);
		lblTipoComida.setText(tipoComida);
		lblDescricao.setText(descricao);
		lblNotaP.setText(notaP);
		lblNotaC.setText(notaC);
	}
	
	// Volta pra Tela Principal
		public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
			String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();
				
			if(tipoUsuario == "ADMIN") {
				controladorCenas.TrocarTelaPrincipalAdm(event);
			}
			else{
				controladorCenas.TrocarTelaPrincipal(event);
			}
		}
	
	// Vai pra tela de Submeter Avaliação
	public void TrocarEscreverAvaliacao(ActionEvent event) throws IOException {
		controladorCenas.TrocarEscreverAvaliacao(event);
	}

}