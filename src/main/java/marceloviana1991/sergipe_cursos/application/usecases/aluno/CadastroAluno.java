package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

public class CadastroAluno {

    private final RepositorioAluno repositorio;

    public CadastroAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public AlunoResponseDto cadastrarAluno(AlunoRequestDto requestDto) {
        return repositorio.cadastrarAluno(requestDto);
    }
}
