package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;

public class AtualizacaoCurso {

    private final RepositorioCurso repositorio;

    public AtualizacaoCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public Curso atualizarCurso(Long id, Curso curso) {
        return repositorio.atualizarCurso(id, curso);
    }
}
