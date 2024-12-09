package marceloviana1991.sergipe_cursos.application.dto.aluno;

import java.time.LocalDate;

public record AlunoResponseDto(String id, String cpf, String nome, LocalDate nascimento, String email) {
}
