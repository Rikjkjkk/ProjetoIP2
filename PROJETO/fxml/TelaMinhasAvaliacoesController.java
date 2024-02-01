package PROJETO.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Modelo.Avaliacao;
import PROJETO.ReviewRestaurante.Modelo.Usuario;
import PROJETO.ReviewRestaurante.Negocio.ControladorAvaliacao;
import PROJETO.ReviewRestaurante.Negocio.GerenciadorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class TelaMinhasAvaliacoesController {
	
	@FXML private Button btnVoltar;
	@FXML private ListView<Avaliacao> listarAvaliacoes;
	
	ControladorCenas controladorCenas = ControladorCenas.getInstance();
	GerenciadorSessao sessao = GerenciadorSessao.getInstancia();
	Usuario usuarioLogado = sessao.getUsuarioOnline();
	
	public List<Avaliacao> PesquisaAvaliacao(ActionEvent event)throws IOException, ObjetoInvalidoException {
		ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
		String nomeUsuario = usuarioLogado.getNome();
		
		List<Avaliacao> resultAvaliacoes = controladorAvaliacao.buscarAvaliacoes(nomeUsuario);
		
		return resultAvaliacoes;
		
	}
	
	public void initialize(URL arg0, ResourceBundle arg1, ActionEvent event) throws IOException, ObjetoInvalidoException {
		listarAvaliacoes.getItems().addAll(PesquisaAvaliacao(null));
    }
	
	// Ir para Tela de Meu Perfil
	public void TrocarTelaPerfil(ActionEvent event) throws IOException {
		controladorCenas.TrocarTelaPerfil(event);
	}
	
}