package br.ufrpe.projetoip2.exception;

public class CamposNaoPreenchidosException extends Exception{
    public CamposNaoPreenchidosException() {
        super("Um ou mais campos estão vazios.");
    }

    public CamposNaoPreenchidosException(String mensagem) {
        super(mensagem);
    }
}
