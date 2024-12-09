package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;

public class DetalhamentoCurso {

    private final RepositorioCurso repositorio;

    public DetalhamentoCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public CursoResponseDto detalharCurso(String id) {
        return repositorio.detalharCurso(id);
    }
}
