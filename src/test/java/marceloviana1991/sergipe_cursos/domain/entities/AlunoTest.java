package marceloviana1991.sergipe_cursos.domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AlunoTest {
    @Test
    public void naoDeveCadastrarAlunoComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Aluno("12345678999",
                        "Aluno",
                        LocalDate.parse("2024-01-01"),
                        "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Aluno(null,
                        "Aluno",
                        LocalDate.parse("2024-01-01"),
                        "email@email.com"));
    }
}
