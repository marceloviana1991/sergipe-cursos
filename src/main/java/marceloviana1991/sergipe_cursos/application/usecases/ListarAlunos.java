package marceloviana1991.sergipe_cursos.application.usecases;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioDeAluno;
import marceloviana1991.sergipe_cursos.domain.entities.Aluno;

import java.util.List;

public class ListarAlunos {

    private final RepositorioDeAluno repositorio;

    public ListarAlunos(RepositorioDeAluno repositorio) {
        this.repositorio = repositorio;
    }

    public List<Aluno> listarAlunos(Aluno aluno) {
        return repositorio.listarAlunos();
    }
}
