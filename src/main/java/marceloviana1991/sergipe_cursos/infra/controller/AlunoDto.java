package marceloviana1991.sergipe_cursos.infra.controller;

import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.time.LocalDate;

public record AlunoDto(Long id, String cpf, String nome, LocalDate nascimento, String email) {
    public AlunoDto(Aluno aluno) {
        this(aluno.getId(), aluno.getCpf(), aluno.getNome(), aluno.getNascimento(), aluno.getEmail());
    }
}
