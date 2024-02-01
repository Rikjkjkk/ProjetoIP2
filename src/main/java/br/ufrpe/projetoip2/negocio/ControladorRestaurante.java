package br.ufrpe.projetoip2.negocio;

import br.ufrpe.projetoip2.beans.Avaliacao;
import br.ufrpe.projetoip2.beans.Restaurante;
import br.ufrpe.projetoip2.beans.TipoComida;
import br.ufrpe.projetoip2.dados.IRepositorioGenerico;
import br.ufrpe.projetoip2.dados.RepositorioGenerico;
import br.ufrpe.projetoip2.exception.ObjetoInvalidoException;
import br.ufrpe.projetoip2.exception.ObjetoJaExisteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControladorRestaurante {
    private final IRepositorioGenerico<Restaurante> repositorioRestaurantes;
    private static ControladorRestaurante instancia;

    // Controlador
    public ControladorRestaurante() {
        this.repositorioRestaurantes = new RepositorioGenerico<>();
    }

    // Pega a instância do controlador
    public static ControladorRestaurante getInstancia() {
        if (instancia == null) {
            instancia = new ControladorRestaurante();
        }
        return instancia;
    }

    // CRUD
    public void adicionarRestaurante(Restaurante restaurante) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if (restaurante != null){
            if(!restaurante.getNome().isEmpty() && restaurante.getTipoComida() != null && !restaurante.getDescricao().isEmpty()){
                repositorioRestaurantes.adicionar(restaurante);
            }
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public List<Restaurante> listarRestaurantes() {
        return repositorioRestaurantes.listar();
    }

    public void removerRestaurante(Restaurante restaurante) throws ObjetoInvalidoException {
        if (restaurante != null){
            repositorioRestaurantes.remover(restaurante);
        }
        else{
            throw new ObjetoInvalidoException();
        }
    }

    public void editarRestaurante(Restaurante restaurante, Restaurante novo) throws ObjetoInvalidoException, ObjetoJaExisteException {
        if(!listarRestaurantes().contains(novo)){
            if (restaurante != null && novo != null){
                if(!novo.getNome().isEmpty() && novo.getTipoComida() != null && !novo.getDescricao().isEmpty() &&  novo.getNotaCriticos() != 0 && novo.getNotaPublico() != 0){
                    repositorioRestaurantes.editar(restaurante, novo);
                }
            }
            else {
                throw new ObjetoInvalidoException(restaurante);
            }
        }
        else{
            throw new ObjetoJaExisteException(novo);
        }
    }

    // Buscar um restaurante passando ele como parâmetro
    public List<Restaurante> buscarRestaurante(Object T) throws ObjetoInvalidoException {
        List<Restaurante> restaurantes = this.listarRestaurantes();
        if (T instanceof String palavra) {
            if (palavra.isBlank()) {
                return restaurantes;
            }
            else {
                List<Restaurante> resultados = new ArrayList<>();
                for (Restaurante restaurante : restaurantes) {
                    String[] palavras = restaurante.getNome().split("\\s+");
                    for (String p : palavras) {
                        if(p.equalsIgnoreCase(palavra)) {
                            resultados.add(restaurante);
                            break;
                        }
                    }
                }
                return resultados;
            }
        }
        else if (T instanceof TipoComida tipo) {
            List<Restaurante> resultados = new ArrayList<>();
            for (Restaurante restaurante : restaurantes) {
                if (restaurante.getTipoComida().equals(tipo)) {
                    resultados.add(restaurante);
                }
            }
            return resultados;
        }
        else {
            throw new ObjetoInvalidoException();
        }
    }

    // Método para calcular a média das notas
    public void calcularMediaNotas(Restaurante restaurante) {
        List<Avaliacao> avaliacoesPublico = restaurante.getAvaliacoesPublico();
        List<Avaliacao> avaliacoesCriticos = restaurante.getAvaliacoesCriticos();

        // Calcular média das notas do público
        if (avaliacoesPublico.isEmpty()) {
            restaurante.setNotaPublico(0.0); // Defina um valor padrão para quando não houver avaliações
        } else {
            double totalNotas = 0.0;
            for (Avaliacao avaliacao : avaliacoesPublico) {
                totalNotas += avaliacao.getNota();
            }
            restaurante.setNotaPublico(totalNotas / avaliacoesPublico.size());
        }

        // Calcular média das notas dos críticos
        if (avaliacoesCriticos.isEmpty()) {
            restaurante.setNotaCriticos(0.0); // Defina um valor padrão para quando não houver avaliações
        } else {
            double totalNotas = 0.0;
            for (Avaliacao avaliacao : avaliacoesCriticos) {
                totalNotas += avaliacao.getNota();
            }
            restaurante.setNotaCriticos(totalNotas / avaliacoesCriticos.size());
        }
    }

    // Busca os restaurantes com as melhores notas dos usuários Padrão
    public List<Restaurante> buscarMelhoresPublico() {
        List<Restaurante> restaurantes = ControladorRestaurante.getInstancia().listarRestaurantes();
        restaurantes.sort(new Comparator<Restaurante>() {
            @Override
            public int compare(Restaurante restaurante1, Restaurante restaurante2) {
                Double nota1 = restaurante1.getNotaPublico();
                Double nota2 = restaurante2.getNotaPublico();

                if (nota1 == null && nota2 == null) {
                    return 0;
                } else if (nota1 == null) {
                    return 1;
                } else if (nota2 == null) {
                    return -1;
                } else {
                    return Double.compare(nota2, nota1);
                }
            }
        });
        return restaurantes;
    }

    // Busca os restaurante com as melhores notas dos usuários Críticos
    public List<Restaurante> buscarMelhoresCritico() {
        List<Restaurante> restaurantes = ControladorRestaurante.getInstancia().listarRestaurantes();
        restaurantes.sort(new Comparator<Restaurante>() {
            @Override
            public int compare(Restaurante restaurante1, Restaurante restaurante2) {
                Double nota1 = restaurante1.getNotaCriticos();
                Double nota2 = restaurante2.getNotaCriticos();

                if (nota1 == null && nota2 == null) {
                    return 0;
                } else if (nota1 == null) {
                    return 1;
                } else if (nota2 == null) {
                    return -1;
                } else {
                    return Double.compare(nota2, nota1);
                }
            }
        });
        return restaurantes;
    }
}
