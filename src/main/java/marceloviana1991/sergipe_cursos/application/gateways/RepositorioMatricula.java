package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.domain.Matricula;

import java.util.List;

public interface RepositorioMatricula {
    Matricula cadastrarMatricula(Long alunoId, Long cursoId);
    List<Matricula> listarMatriculas();
}
