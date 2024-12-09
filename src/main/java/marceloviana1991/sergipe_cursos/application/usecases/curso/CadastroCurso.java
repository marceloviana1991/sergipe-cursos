package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;

public class CadastroCurso {

    private final RepositorioCurso repositorio;

    public CadastroCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public CursoResponseDto cadastrarCurso (String nome, String descricao, Integer vagas) {
        return repositorio.cadastrarCurso(nome, descricao, vagas);
    }
}
