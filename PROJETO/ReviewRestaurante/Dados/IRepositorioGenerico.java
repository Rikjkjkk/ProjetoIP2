package PROJETO.ReviewRestaurante.Dados;

import java.util.List;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;


public interface IRepositorioGenerico<T> {

    void adicionar(T objeto) throws ObjetoJaExisteException;

    List<T> listar();

    void remover(T objeto) throws ObjetoInvalidoException;

    void editar(T objeto, T novo) throws ObjetoInvalidoException;

}