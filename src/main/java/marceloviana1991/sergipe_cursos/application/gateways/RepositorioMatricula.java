package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;

import java.util.List;

public interface RepositorioMatricula {
    MatriculaResponseDto cadastrarMatricula(MatriculaRequestDto requestDto);
    List<MatriculaResponseDto> listarMatriculas();
    List<String> listarAlunosMatriculados(String cursoId);
}
