package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;

public class DetalhamentoAluno {

    private final RepositorioAluno repositorio;

    public DetalhamentoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public Aluno detalharAluno(Long id) {
        return repositorio.detalharAluno(id);
    }
}
