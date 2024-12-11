package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;

import java.util.List;

public class ListagemAlunosMatriculados {

    private final RepositorioMatricula repositorio;

    public ListagemAlunosMatriculados(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public List<String> listarAlunosMatriculados(String cursoId) {
        return repositorio.listarAlunosMatriculados(cursoId);
    }
}
