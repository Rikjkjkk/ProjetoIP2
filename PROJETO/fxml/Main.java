package PROJETO.fxml;

import PROJETO.ReviewRestaurante.Negocio.ControladorAvaliacao;
import PROJETO.ReviewRestaurante.Negocio.ControladorRestaurante;
import PROJETO.ReviewRestaurante.Negocio.ControladorUsuario;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Modelo.Usuario;
import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.TipoDeConta;
import PROJETO.ReviewRestaurante.Modelo.TipoComida;
import PROJETO.ReviewRestaurante.Modelo.Avaliacao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
			Scene scene = new Scene(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ObjetoJaExisteException {
		
		ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
		ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();
		ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
		
		Usuario admin = new Usuario("Administrador", "admin", "admin");
		admin.setTipo(TipoDeConta.ADMIN);
		controladorUsuario.adicionarUsuario(admin);
		
		Restaurante spoletto = new Restaurante("Spoletto", TipoComida.ITALIANA, "Fast-food de massas italianas");
		Restaurante salebrasa = new Restaurante("Sal e Brasa", TipoComida.CARNES, "Churrascaria com rodízio de carnes");
		Restaurante pizzahut = new Restaurante("Pizza Hut", TipoComida.CARNES, "Pizzaria fast-food, prove o pepperoni");
		controladorRestaurante.adicionarRestaurante(spoletto);
		controladorRestaurante.adicionarRestaurante(salebrasa);
		controladorRestaurante.adicionarRestaurante(pizzahut);
		
		Avaliacao avaliacao1 = new Avaliacao(admin, spoletto, "Amei o ravioli", 4);
		Avaliacao avaliacao2 = new Avaliacao(admin, salebrasa, "Bom, mas já provei melhores", 3);
		Avaliacao avaliacao3 = new Avaliacao(admin, pizzahut, "Horrível!", 1);
		controladorAvaliacao.adicionarAvaliacao(avaliacao1);
		controladorAvaliacao.adicionarAvaliacao(avaliacao2);
		controladorAvaliacao.adicionarAvaliacao(avaliacao3);
		
		Application.launch(args);//<---------------------
		
		
	}
}
