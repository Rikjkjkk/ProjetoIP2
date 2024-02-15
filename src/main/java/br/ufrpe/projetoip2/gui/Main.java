package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.*;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;
import br.ufrpe.projetoip2.negocio.ControladorAvaliacao;
import br.ufrpe.projetoip2.negocio.ControladorRestaurante;
import br.ufrpe.projetoip2.negocio.ControladorUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaCadastro.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ObjetoJaExisteException, ObjetoInvalidoException {

        ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
        ControladorRestaurante controladorRestaurante = ControladorRestaurante.getInstancia();
        ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();

        Usuario admin = new Usuario("Administrador", "admin", "admin");
        admin.setTipo(TipoDeConta.ADMIN);
        controladorUsuario.adicionarUsuario(admin);

        Usuario padrao = new Usuario("Padrão", "p", "p");
        padrao.setTipo(TipoDeConta.PADRAO);
        controladorUsuario.adicionarUsuario(padrao);

        Restaurante atlantico = new Restaurante("Atlântico", TipoComida.PIZZA, "Restaurante e Pizzaria Atlântico, pediu, partiu!");
        Restaurante mcdonalds = new Restaurante("Mc'Donalds", TipoComida.FASTFOOD, "Maior franquia de Fast Food do mundo");
        Restaurante chinaInBox = new Restaurante("China in Box", TipoComida.CHINESA, "Maior rede de comida chinesa no Brasil");
        controladorRestaurante.adicionarRestaurante(atlantico);
        controladorRestaurante.adicionarRestaurante(mcdonalds);
        controladorRestaurante.adicionarRestaurante(chinaInBox);

        Avaliacao avaliacao1 = new Avaliacao(admin, atlantico, "Brabo", 4);
        Avaliacao avaliacao2 = new Avaliacao(admin, mcdonalds, "Superestimado", 3);
        Avaliacao avaliacao3 = new Avaliacao(admin, chinaInBox, "Prefiro o Gendai!", 1);
        controladorAvaliacao.adicionarAvaliacao(avaliacao1);
        controladorAvaliacao.adicionarAvaliacao(avaliacao2);
        controladorAvaliacao.adicionarAvaliacao(avaliacao3);

        Application.launch(args);//<---------------------
    }
}