package br.ufrpe.projetoip2.dados;

import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;

import java.util.List;

public interface IRepositorioGenerico<T> {
    void adicionar(T objeto) throws ObjetoJaExisteException;

    List<T> listar();
    void remover(T objeto) throws ObjetoInvalidoException;
    void editar(T objeto, T novo) throws ObjetoInvalidoException;
}
