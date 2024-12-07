package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;

public class CadastroMatricula {

    private final RepositorioMatricula repositorio;

    public CadastroMatricula(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public Matricula cadastrarMatricula(Long alunoId, Long cursoId) {
        return repositorio.cadastrarMatricula(alunoId, cursoId);
    }
}
