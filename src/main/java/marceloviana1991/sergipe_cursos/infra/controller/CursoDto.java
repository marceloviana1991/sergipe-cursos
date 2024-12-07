package marceloviana1991.sergipe_cursos.infra.controller;

import marceloviana1991.sergipe_cursos.domain.Curso;

public record CursoDto(Long id, String nome, String descricao, Integer vagas) {
    public CursoDto(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getVagas());
    }
}
