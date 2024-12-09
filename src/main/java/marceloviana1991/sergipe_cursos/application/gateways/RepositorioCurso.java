package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;

import java.util.List;

public interface RepositorioCurso {
    CursoResponseDto cadastrarCurso(String nome, String descricao, Integer vagas);
    List<CursoResponseDto> listarCursos();
    CursoResponseDto detalharCurso(String id);
    void excluirCurso(String id);
    CursoResponseDto atualizarCurso(String id, String nome, String descricao, Integer vagas);
}
