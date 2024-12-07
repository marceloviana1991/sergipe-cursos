package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;

public class CadastroMatricula {

    private final RepositorioMatricula repositorio;

    public CadastroMatricula(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public Matricula cadastrarMatricula(Matricula matricula) {
        return repositorio.cadastrarMatricula(matricula);
    }
}
