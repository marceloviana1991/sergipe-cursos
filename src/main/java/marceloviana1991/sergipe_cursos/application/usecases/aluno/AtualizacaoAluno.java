package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;

import java.time.LocalDate;

public class AtualizacaoAluno {

    private final RepositorioAluno repositorio;

    public AtualizacaoAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public AlunoResponseDto atualizarAluno(String id, String nome, LocalDate nascimento) {
        return repositorio.atualizarAluno(id, nome, nascimento);
    }
}
