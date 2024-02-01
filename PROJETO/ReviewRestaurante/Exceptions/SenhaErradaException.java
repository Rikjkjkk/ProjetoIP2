package PROJETO.ReviewRestaurante.Exceptions;

public class SenhaErradaException extends Exception{
    public SenhaErradaException() {
        super("Senha incorreta");
    }
}
