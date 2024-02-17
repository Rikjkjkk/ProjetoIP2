package br.ufrpe.projetoip2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorCenas {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private static ControladorCenas instance;


    public void TrocarTelaCadastro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaCadastro.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaCadastroRealizado(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaCadastroRealizado.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaLogin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaPrincipal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaPrincipalAdm(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaPrincipalAdm.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

//    public void TrocarTelaListaFavoritos(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaListaFavoritos.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
//        stage.setScene(scene);
//        stage.show();
//    }

    public void TrocarTelaListas(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaListas.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaListaAvaliacoes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaListaAvaliacoes.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaPerfil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaPerfil.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

//    public void TrocarEscreverAvaliacao1(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaOpiniao.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
//        stage.setScene(scene);
//        stage.show();
//    }

    public void TrocarPesquisaUsuario(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaPesquisaUsuario.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarOutroUsuario(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaOutroPerfil.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarPesquisaAvaliacao(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaPesquisaAvaliacoes.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarEscreverAvaliacao(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaOpiniao.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaRestaurante(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaRestaurante.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarPesquisaRestaurante(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaPesquisaRestaurante.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaAdicionarRestaurante(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaAdicionarRestaurante.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarTelaMinhasAvaliacoes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaMinhasAvaliacoes.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void TrocarOutrasAvaliacoes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TelaOutrasAvaliacoes.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
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
