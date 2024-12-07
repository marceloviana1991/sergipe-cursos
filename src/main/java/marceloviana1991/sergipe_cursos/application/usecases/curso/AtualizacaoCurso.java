package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;

public class AtualizacaoCurso {

    private final RepositorioCurso repositorio;

    public AtualizacaoCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public CursoResponseDto atualizarCurso(Long id, CursoRequestDto requestDto) {
        return repositorio.atualizarCurso(id, requestDto);
    }
}
