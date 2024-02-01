package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.TipoDeConta;
import br.ufrpe.projetoip2.exception.CamposNaoPreenchidosException;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.SenhaIncorretaException;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import br.ufrpe.projetoip2.negocio.ControladorUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TelaLoginController {
    // Atributos elementos gráficos
    @FXML private TextField txtSenha;
    @FXML private TextField txtLogin;
    @FXML private Button btnCadastro;
    @FXML private Button btnLogin;
    @FXML private Label lblErro;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();
    ControladorSessao sessao = ControladorSessao.getInstancia();

    // Limpa o label de erro
    public void initialize() {
        // Configurar ouvintes de foco para cada campo
        txtLogin.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
            }
        });

        txtSenha.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // Campo recebeu foco
                lblErro.setText(""); // Limpar a mensagem de erro
            }
        });
    }

    // Pega os dados informados nas Boxes, chama a função de login, se verdadeira, Passa pra tela Principal
    public void FazerLogin(ActionEvent event) throws IOException, SenhaIncorretaException, ObjetoInvalidoException, CamposNaoPreenchidosException {
        try {
            // Pegar os dados pra fazer login
            ControladorUsuario controladorUsuario = ControladorUsuario.getInstancia();
            String login = txtLogin.getText();
            String senha = txtSenha.getText();

            // Verifica se os Campos da Interface estão vazios
            if (login.isEmpty() || senha.isEmpty()) {
                throw new CamposNaoPreenchidosException("Por favor, preencha todos os campos.");
            }

            try {
                if (controladorUsuario.login(login, senha)) {
                    String tipoUsuario = sessao.getUsuarioOnline().getTipo().toString();

                    if (tipoUsuario == TipoDeConta.ADMIN.toString()) {
                        controladorCenas.TrocarTelaPrincipalAdm(event);
                    } else {
                        controladorCenas.TrocarTelaPrincipal(event);
                    }
                } else {
                    throw new ObjetoInvalidoException("Usuário não existe ou não encontrado");
                }
            } catch (SenhaIncorretaException e) {
                lblErro.setText("Erro: " + e.getMessage());
            } catch (ObjetoInvalidoException e) {
                lblErro.setText("Erro: O Usuário não está cadastrado");
            }
        } catch (CamposNaoPreenchidosException e) {
            this.lblErro.setText("Erro: " + e.getMessage());
        } catch (IOException e) {
            // Tratar outras exceções aqui, se necessário
        }
    }

    // Ir para Tela Cadastro
    public void irTelaCadastro(ActionEvent event) throws IOException, IOException {
        controladorCenas.TrocarTelaCadastro(event);
    }
}
