package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;

import java.util.List;

public interface RepositorioCurso {
    CursoResponseDto cadastrarCurso(CursoRequestDto requestDto);
    List<CursoResponseDto> listarCursos();
    CursoResponseDto detalharCurso(Long id);
    void excluirCurso(Long id);
    CursoResponseDto atualizarCurso(Long id, CursoRequestDto requestDto);
}
