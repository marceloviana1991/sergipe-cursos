package marceloviana1991.sergipe_cursos;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.infra.gateways.memoria.RepositorioAlunoMemoria;
import marceloviana1991.sergipe_cursos.infra.gateways.memoria.RepositorioCursoMemoria;
import marceloviana1991.sergipe_cursos.infra.gateways.memoria.RepositorioMatriculaMemoria;

import java.time.LocalDate;

public class SergipeCursosAplicacaoEmMemoria {

    public static void main(String[] args) {
        RepositorioCursoMemoria repositorioCursoMemoria = new RepositorioCursoMemoria();
        repositorioCursoMemoria.cadastrarCurso(
                new CursoRequestDto("curso ", "descricao", 2)
        );

        RepositorioAlunoMemoria repositorioAlunoMemoria = new RepositorioAlunoMemoria();
        repositorioAlunoMemoria.cadastrarAluno(
                new AlunoRequestDto("000.000.000-00", "aluno", LocalDate.parse("2024-01-01"),
                        "email@email.com")
        );

        RepositorioMatriculaMemoria repositorioMatriculaMemoria = new RepositorioMatriculaMemoria(
                repositorioCursoMemoria,
                repositorioAlunoMemoria
        );
        repositorioMatriculaMemoria.cadastrarMatricula(
                new MatriculaRequestDto(0L,0L)
        );

        System.out.println(repositorioAlunoMemoria.listarAlunos());
        System.out.println(repositorioCursoMemoria.listarCursos());
        System.out.println(repositorioMatriculaMemoria.listarMatriculas());


    }




}
