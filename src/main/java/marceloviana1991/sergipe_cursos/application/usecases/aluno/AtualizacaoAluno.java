package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;

public class AtualizacaoAluno {

    private final RepositorioAluno repositorio;

    public AtualizacaoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public Aluno atualizarAluno(Long id, Aluno aluno) {
        return repositorio.atualizarAluno(id, aluno);
    }
}
