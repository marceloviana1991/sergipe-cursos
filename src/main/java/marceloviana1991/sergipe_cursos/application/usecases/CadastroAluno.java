package marceloviana1991.sergipe_cursos.application.usecases;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.entities.Aluno;

public class CadastroAluno {

    private final RepositorioAluno repositorio;

    public CadastroAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return repositorio.cadastrarAluno(aluno);
    }
}
