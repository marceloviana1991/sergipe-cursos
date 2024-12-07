package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;

import java.util.List;

public class ListagemCurso {

    private final RepositorioCurso repositorio;

    public ListagemCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public List<Curso> listarCursos() {
        return repositorio.listarCursos();
    }
}
