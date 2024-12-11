package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

import java.util.List;

public class ListagemEmailsCadastrados {

    private final RepositorioAluno repositorio;

    public ListagemEmailsCadastrados(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public List<String> listarEmailsCadastrados() {
        return repositorio.listarEmailsCadastrados();
    }
}
