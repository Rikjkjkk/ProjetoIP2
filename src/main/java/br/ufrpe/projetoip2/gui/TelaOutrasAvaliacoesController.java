package br.ufrpe.projetoip2.gui;

import br.ufrpe.projetoip2.beans.Avaliacao;
import br.ufrpe.projetoip2.beans.Usuario;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.negocio.ControladorAvaliacao;
import br.ufrpe.projetoip2.negocio.ControladorSessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaOutrasAvaliacoesController {
    @FXML
    private Button btnVoltar;
    @FXML private ListView<Avaliacao> listarAvaliacoes;

    ControladorCenas controladorCenas = ControladorCenas.getInstance();

    ControladorSessao sessao = ControladorSessao.getInstancia();
    Usuario usuarioEscolhido = sessao.getUsuarioTemp();

    public List<Avaliacao> PesquisaAvaliacao(ActionEvent event)throws IOException, ObjetoInvalidoException {
        ControladorAvaliacao controladorAvaliacao = ControladorAvaliacao.getInstancia();
        String nomeUsuario = usuarioEscolhido.getNome();

        List<Avaliacao> resultAvaliacoes = controladorAvaliacao.buscarAvaliacoes(nomeUsuario);

        return resultAvaliacoes;

    }

    public void initialize(URL arg0, ResourceBundle arg1, ActionEvent event) throws IOException, ObjetoInvalidoException {
        listarAvaliacoes.getItems().addAll(PesquisaAvaliacao(null));
    }

    // Voltar para Tela Principal
    public void TrocarPesquisaUsuario(ActionEvent event) throws IOException {
        controladorCenas.TrocarPesquisaUsuario(event);
    }
}
