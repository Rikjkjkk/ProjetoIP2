package br.ufrpe.projetoip2.exception;

public class ParametroInvalidoException extends Exception{
    private Object objeto;

    public ParametroInvalidoException() {
        super("Parâmetro inválido para busca");
    }

    public ParametroInvalidoException(Object T) {
        this.objeto = T;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
