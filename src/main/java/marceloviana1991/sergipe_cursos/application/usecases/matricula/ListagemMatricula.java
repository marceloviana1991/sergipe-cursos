package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;

import java.util.List;

public class ListagemMatricula {

    private final RepositorioMatricula repositorio;

    public ListagemMatricula(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public List<Matricula> listarMatriculas() {
        return repositorio.listarMatriculas();
    }
}
