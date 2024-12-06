package marceloviana1991.sergipe_cursos.application.usecases;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.entities.Aluno;

import java.util.List;

public class ListagemAluno {

    private final RepositorioAluno repositorio;

    public ListagemAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public List<Aluno> listarAlunos(Aluno aluno) {
        return repositorio.listarAlunos();
    }
}