package marceloviana1991.sergipe_cursos.application.usecases;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

public class ExclusaoAluno {

    private final RepositorioAluno repositorio;

    public ExclusaoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirAluno(Long id) {
        repositorio.excluirAluno(id);
    }
}
