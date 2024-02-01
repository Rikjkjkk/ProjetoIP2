package br.ufrpe.projetoip2.exception;

public class ObjetoJaExisteException extends Exception{
    private Object objeto;

    public ObjetoJaExisteException(Object T) {
        super("O objeto já está presente no sistema");
        this.objeto = T;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
