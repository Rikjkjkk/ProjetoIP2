package PROJETO.ReviewRestaurante.Exceptions;

public class ObjetoJaExisteException extends Exception {
    private Object objeto;

    public ObjetoJaExisteException(Object T) {
        super("O objeto já está cadastrado no sistema.");
        this.objeto = T;
    }

    public Object getObjeto() {
        return this.objeto;
    }
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}