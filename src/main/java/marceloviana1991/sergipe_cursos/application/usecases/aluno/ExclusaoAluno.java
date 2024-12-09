package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

public class ExclusaoAluno {

    private final RepositorioAluno repositorio;

    public ExclusaoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirAluno(String id) {
        repositorio.excluirAluno(id);
    }
}
