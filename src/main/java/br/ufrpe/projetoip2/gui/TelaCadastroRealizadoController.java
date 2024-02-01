package br.ufrpe.projetoip2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class TelaCadastroRealizadoController {
    @FXML private Button btnTelaLogin;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    // Ir para Login
    public void irTelaLogin(ActionEvent event) throws IOException {
        controladorCenas.TrocarTelaLogin(event);
    }
}
