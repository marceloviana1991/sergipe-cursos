package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;

import java.util.List;

public class ListagemCurso {

    private final RepositorioCurso repositorio;

    public ListagemCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public List<CursoResponseDto> listarCursos() {
        return repositorio.listarCursos();
    }
}
