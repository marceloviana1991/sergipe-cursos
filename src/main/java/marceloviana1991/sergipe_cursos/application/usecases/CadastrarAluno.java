package marceloviana1991.sergipe_cursos.application.usecases;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioDeAluno;
import marceloviana1991.sergipe_cursos.domain.entities.Aluno;

public class CadastrarAluno {
    private final RepositorioDeAluno repositorio;

    public CadastrarAluno(RepositorioDeAluno repositorio) {
        this.repositorio = repositorio;
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        return repositorio.cadastrarAluno(aluno);
    }
}
