package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

public class AtualizacaoAluno {

    private final RepositorioAluno repositorio;

    public AtualizacaoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public AlunoResponseDto atualizarAluno(Long id, AlunoRequestDto requestDto) {
        return repositorio.atualizarAluno(id, requestDto);
    }
}
