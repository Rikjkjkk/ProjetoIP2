package PROJETO.ReviewRestaurante.Negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import PROJETO.ReviewRestaurante.Dados.IRepositorioGenerico;
import PROJETO.ReviewRestaurante.Dados.RepositorioGenerico;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoInvalidoException;
import PROJETO.ReviewRestaurante.Exceptions.ObjetoJaExisteException;
import PROJETO.ReviewRestaurante.Modelo.Restaurante;
import PROJETO.ReviewRestaurante.Modelo.TipoComida;

public class ControladorRestaurante {
    private IRepositorioGenerico<Restaurante> repositorioRestaurantes;
    
    private static ControladorRestaurante instancia;

    private ControladorRestaurante() {
        this.repositorioRestaurantes = new RepositorioGenerico<>("restaurantes.dat");
    }

    public static ControladorRestaurante getInstancia() {
        if (instancia == null) {
            instancia = new ControladorRestaurante();
        }
        return instancia;
    }

    public void adicionarRestaurante(Restaurante restaurante) throws ObjetoJaExisteException {
        repositorioRestaurantes.adicionar(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        return repositorioRestaurantes.listar();
    }

    public void removerRestaurante(Restaurante restaurante) throws ObjetoInvalidoException {
        repositorioRestaurantes.remover(restaurante);
    }

    public void editarRestaurante(Restaurante restaurante, Restaurante novo) throws ObjetoInvalidoException {
        repositorioRestaurantes.editar(restaurante, novo);
    }

    public List<Restaurante> buscarRestaurantes(Object T) throws ObjetoInvalidoException {
        List<Restaurante> restaurantes = this.listarRestaurantes();
        if (T instanceof String) {
            String palavra = (String) T;
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
        else if (T instanceof TipoComida) {
            TipoComida tipo = (TipoComida) T;
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
        
    public List<Restaurante> buscarMelhoresPublico() {
        List<Restaurante> restaurantes = ControladorRestaurante.getInstancia().listarRestaurantes();
        Collections.sort(restaurantes, new Comparator<Restaurante>() {
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

    public List<Restaurante> buscarMelhoresCritico() {
        List<Restaurante> restaurantes = ControladorRestaurante.getInstancia().listarRestaurantes();
        Collections.sort(restaurantes, new Comparator<Restaurante>() {
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