package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.util.List;

public class ListagemAluno {

    private final RepositorioAluno repositorio;

    public ListagemAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public List<Aluno> listarAlunos() {
        return repositorio.listarAlunos();
    }
}
