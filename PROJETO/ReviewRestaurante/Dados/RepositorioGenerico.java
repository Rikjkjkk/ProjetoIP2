package PROJETO.ReviewRestaurante.Dados;

import java.util.ArrayList;
import java.util.List;

import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T> {
    protected List<T> lista;
    public String arquivo;
    
    public RepositorioGenerico(String nome) {
        this.lista = new ArrayList<>();

        Object arquivoRepositorio = RepositorioArquivos.ler(nome);
        if (arquivoRepositorio instanceof List<?> && arquivoRepositorio != null) {
            this.lista = (List<T>) arquivoRepositorio;
        }
    }

    @Override
    public void adicionar(T objeto) throws ObjetoJaExisteException {
        if (!this.lista.contains(objeto)) {
            this.lista.add(objeto);
        }
        else {
            throw new ObjetoJaExisteException(objeto);
        }
        RepositorioArquivos.salvar(lista, arquivo);
    }

    @Override
    public List<T> listar() {
        return lista;
    }

    @Override
    public void remover(T objeto) throws ObjetoInvalidoException {
        if (this.lista.contains(objeto)) {
            lista.remove(this.lista.indexOf(objeto));
        }
        else {
            throw new ObjetoInvalidoException(objeto);
        }
        RepositorioArquivos.salvar(lista, arquivo);
    }

    @Override
    public void editar(T objeto, T novo) throws ObjetoInvalidoException {
        if (this.lista.contains(objeto)) {
            int i = this.lista.indexOf(objeto);
            this.lista.set(i, novo);
        }
        else {
            throw new ObjetoInvalidoException(objeto);
        }
        RepositorioArquivos.salvar(lista, arquivo);
    }
}
