package marceloviana1991.sergipe_cursos.domain.entities;

import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.domain.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MatriculaTest {

    @Test
    public void naoDeveRealizarMatriculaEmCursoSemVagaDisponivel(){
        Aluno aluno = new Aluno("111.111.111-11","Aluno", LocalDate.parse("2024-01-01"),
                "email@email.com");
        Curso curso = new Curso("curso", "", 0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Matricula(aluno, curso));
    }
}
