package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;

public class DetalhamentoCurso {

    private final RepositorioCurso repositorio;

    public DetalhamentoCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public Curso detalharCurso(Long id) {
        return repositorio.detalharCurso(id);
    }
}
