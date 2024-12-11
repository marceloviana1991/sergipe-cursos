package marceloviana1991.sergipe_cursos.application.usecases.matricula;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;

public class VerificaQuantidadeDeVagasDisponiveis {

    private final RepositorioMatricula repositorio;

    public VerificaQuantidadeDeVagasDisponiveis(RepositorioMatricula repositorio) {
        this.repositorio = repositorio;
    }

    public Integer verificarQuantidadeDeVagasDisponiveis(String cursoId) {
        return repositorio.verificarQuantidadeDeVagasDisponiveis(cursoId);
    }
}
