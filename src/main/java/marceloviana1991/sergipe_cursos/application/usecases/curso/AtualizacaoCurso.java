package marceloviana1991.sergipe_cursos.application.usecases.curso;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;

public class AtualizacaoCurso {

    private final RepositorioCurso repositorio;

    public AtualizacaoCurso(RepositorioCurso repositorio) {
        this.repositorio = repositorio;
    }

    public CursoResponseDto atualizarCurso(String id, String nome, String descricao, Integer vagas) {
        return repositorio.atualizarCurso(id, nome, descricao, vagas);
    }
}
