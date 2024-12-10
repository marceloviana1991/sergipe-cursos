package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;


import java.time.LocalDate;
import java.util.List;

public interface RepositorioAluno {
    AlunoResponseDto cadastrarAluno(String cpf, String nome, LocalDate nascimento, String email);
    List<AlunoResponseDto> listarAlunos();
    AlunoResponseDto detalharAluno(String id);
    void excluirAluno(String id);
    AlunoResponseDto atualizarAluno(String id, String nome, LocalDate nascimento);
}
