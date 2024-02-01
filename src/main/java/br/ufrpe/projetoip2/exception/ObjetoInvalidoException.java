package br.ufrpe.projetoip2.exception;

public class ObjetoInvalidoException extends Exception{
    private Object objeto;

    public ObjetoInvalidoException() {
        super("Objeto inválido para busca");
    }

    public ObjetoInvalidoException(Object T) {
        super("O objeto não está presente no sistema");
        this.objeto = T;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
