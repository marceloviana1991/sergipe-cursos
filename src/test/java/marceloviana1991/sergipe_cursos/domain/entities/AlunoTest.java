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

    @Test
    public void naoDeveCadastrarAlunoComEmailNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Aluno("123.456.789-99",
                        "Aluno",
                        LocalDate.parse("2024-01-01"),
                        "email"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Aluno("123.456.789-99",
                        "Aluno",
                        LocalDate.parse("2024-01-01"),
                        null));
    }

    @Test
    public void naoDeveAdicionarEnderecoNoFormatoInvalido() {
        Aluno aluno = new Aluno("123.456.789-99",
                "Aluno",
                LocalDate.parse("2024-01-01"),
                "email@email.com");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> aluno.adicionarEndereco("49000000",
                        40,
                        null));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> aluno.adicionarEndereco(null,
                        40,
                        null));
    }
}
