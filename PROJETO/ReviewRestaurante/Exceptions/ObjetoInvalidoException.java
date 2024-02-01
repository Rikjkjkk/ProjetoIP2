package PROJETO.ReviewRestaurante.Exceptions;

public class ObjetoInvalidoException extends Exception {
    private Object objeto;

    public ObjetoInvalidoException() {
        super("Objeto inválido para busca");
    }
    public ObjetoInvalidoException(Object T) {
        super("O objeto não está presente no sistema.");
        this.objeto = T;
    }

    public Object getObjeto() {
        return this.objeto;
    }
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}