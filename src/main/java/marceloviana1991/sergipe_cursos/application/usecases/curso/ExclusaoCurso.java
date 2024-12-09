package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;

public class ExclusaoCurso {

    private final RepositorioCurso repositorio;

    public ExclusaoCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirCurso(String id) {
        repositorio.excluirCurso(id);
    }
}
