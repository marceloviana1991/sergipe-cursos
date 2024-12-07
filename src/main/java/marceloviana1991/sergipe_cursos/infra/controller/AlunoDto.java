package marceloviana1991.sergipe_cursos.infra.controller;

import java.time.LocalDate;

public record AlunoDto(String cpf, String nome, LocalDate nascimento, String email) {
}
