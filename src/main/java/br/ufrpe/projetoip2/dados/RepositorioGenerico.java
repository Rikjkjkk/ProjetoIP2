package br.ufrpe.projetoip2.dados;

import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T>{
    // Atributos
    protected List<T> lista;

    // Construtor
    public RepositorioGenerico() {
        this.lista = new ArrayList<>();
    }

    // Métodos da Interface
    @Override
    public void adicionar(T objeto) throws ObjetoJaExisteException {
        if(!this.lista.contains(objeto)){
            this.lista.add(objeto);
        }
        else{
            throw new ObjetoJaExisteException(objeto);
        }
    }

    @Override
    public List<T> listar() {
        return lista;
    }

    @Override
    public void remover(T objeto) throws ObjetoInvalidoException {
        if(this.lista.contains(objeto)){
            this.lista.remove(objeto);
        }
        else{
            throw new ObjetoInvalidoException(objeto);
        }
    }

    @Override
    public void editar(T objeto, T novo) throws ObjetoInvalidoException {
        if(this.lista.contains(objeto)){
            int i = this.lista.indexOf(objeto);
            this.lista.set(i, novo);
        }
        else{
            throw new ObjetoInvalidoException(objeto);
        }
    }
}
