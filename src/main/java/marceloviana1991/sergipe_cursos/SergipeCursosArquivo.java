package marceloviana1991.sergipe_cursos;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.infra.gateways.arquivo.RepositorioAlunoArquivo;

import java.time.LocalDate;

public class SergipeCursosArquivo {

    public static void main(String[] args) {
        RepositorioAlunoArquivo repositorioAlunoArquivo = new RepositorioAlunoArquivo();
        repositorioAlunoArquivo.cadastrarAluno(
                new AlunoRequestDto("111.111.111-11",
                        "aluno",
                        LocalDate.parse("2024-01-01"),
                        "email@eamil.com")
        );
        repositorioAlunoArquivo.cadastrarAluno(
                new AlunoRequestDto("111.111.111-11",
                        "aluno 2",
                        LocalDate.parse("2024-01-01"),
                        "email@eamil.com")
        );
        repositorioAlunoArquivo.cadastrarAluno(
                new AlunoRequestDto("111.111.111-11",
                        "aluno 3",
                        LocalDate.parse("2024-01-01"),
                        "email@eamil.com")
        );
        System.out.println(repositorioAlunoArquivo.listarAlunos());
        repositorioAlunoArquivo.atualizarAluno(2l,
                new AlunoRequestDto("111.111.111-11",
                        "aluno 3 atualizado",
                        LocalDate.parse("2024-01-01"),
                        "email@eamil.com")
                );
        System.out.println(repositorioAlunoArquivo.listarAlunos());
        //repositorioAlunoArquivo.gravaEmArquivo("alunos");
    }
}
