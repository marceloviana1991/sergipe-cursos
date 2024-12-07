package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;

public class CadastroMatricula {

    private final RepositorioMatricula repositorio;

    public CadastroMatricula(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public MatriculaResponseDto cadastrarMatricula(MatriculaRequestDto requestDto) {
        return repositorio.cadastrarMatricula(requestDto);
    }
}
