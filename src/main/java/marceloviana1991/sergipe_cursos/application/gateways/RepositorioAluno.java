package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;

import java.util.List;

public interface RepositorioAluno {
    AlunoResponseDto cadastrarAluno(AlunoRequestDto requestDto);
    List<AlunoResponseDto> listarAlunos();
    AlunoResponseDto detalharAluno(Long id);
    void excluirAluno(Long id);
    AlunoResponseDto atualizarAluno(Long id, AlunoRequestDto requestDto);
}
