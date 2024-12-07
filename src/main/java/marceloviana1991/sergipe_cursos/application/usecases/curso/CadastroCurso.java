package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;

public class CadastroCurso {

    private final RepositorioCurso repositorio;

    public CadastroCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public Curso cadastrarCurso (Curso curso) {
        return repositorio.cadastrarCurso(curso);
    }
}
