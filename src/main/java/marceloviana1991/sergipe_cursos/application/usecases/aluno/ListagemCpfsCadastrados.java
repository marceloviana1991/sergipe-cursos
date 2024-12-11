package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

import java.util.List;

public class ListagemCpfsCadastrados {

    private final RepositorioAluno repositorio;

    public ListagemCpfsCadastrados(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public List<String> listarCpfsCadastrados() {
        return repositorio.listarCpfsCadastrados();
    }

}
