package marceloviana1991.sergipe_cursos.application.usecases.aluno;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.time.LocalDate;

public class CadastroAluno {

    private final RepositorioAluno repositorio;

    public CadastroAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public AlunoResponseDto cadastrarAluno(String cpf, String nome, LocalDate nascimento, String email) {
        return repositorio.cadastrarAluno(cpf, nome, nascimento, email);
    }
}
