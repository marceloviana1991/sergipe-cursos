package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

public class DetalhamentoAluno {

    private final RepositorioAluno repositorio;

    public DetalhamentoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public AlunoResponseDto detalharAluno(Long id) {
        return repositorio.detalharAluno(id);
    }
}
