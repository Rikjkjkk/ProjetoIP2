package PROJETO.fxml;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorCenas {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private static ControladorCenas instance;
	
	
	public void TrocarTelaInicial(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaCadastro(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaCadastroRealizado(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaCadastroRealizado.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaPrincipalAdm(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPrincipalAdm.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaListaFavoritos(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaListaFavoritos.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaListas(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaListas.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaListaAvaliacoes(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaListaAvaliacoes.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaPerfil(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPerfil.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarEscreverAvaliacao1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaOpiniao.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaRestaurante1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaRestaurante.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaAdicionarRestaurante(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaAdicionarRestaurante.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarPesquisaRestaurante1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPesquisaRestaurante.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarPesquisaUsuario(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPesquisaUsuario.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarOutroUsuario(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaOutroPerfil.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarPesquisaAvaliacao(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPesquisaAvaliacoes.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarEscreverAvaliacao(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaOpiniao.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarTelaRestaurante(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaRestaurante.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarPesquisaRestaurante(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPesquisaRestaurante.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void TrocarPesquisaUsuariop(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("TelaPesquisaUsuario.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public static ControladorCenas getInstance() {
        if (instance == null) {
            instance = new ControladorCenas();
        }
        return instance;
    }
}