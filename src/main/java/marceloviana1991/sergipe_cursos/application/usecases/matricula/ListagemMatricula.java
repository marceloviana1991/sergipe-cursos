package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;

import java.util.List;

public class ListagemMatricula {

    private final RepositorioMatricula repositorio;

    public ListagemMatricula(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public List<MatriculaResponseDto> listarMatriculas() {
        return repositorio.listarMatriculas();
    }
}
