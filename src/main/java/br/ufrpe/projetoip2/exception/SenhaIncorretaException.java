package br.ufrpe.projetoip2.exception;

public class SenhaIncorretaException extends Exception{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}
