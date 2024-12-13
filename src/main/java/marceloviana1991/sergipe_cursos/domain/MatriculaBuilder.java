package marceloviana1991.sergipe_cursos.domain;

import java.util.List;

public class MatriculaBuilder {
    private final List<String> listaDeCpsDeAlunosMatriculados;

    public MatriculaBuilder(List<String> listaDeCpsDeAlunosMatriculados) {
        this.listaDeCpsDeAlunosMatriculados = listaDeCpsDeAlunosMatriculados;
    }

    public void verificaSeAlunoJaPossuiMatriculaNoCurso(String cpf) {
        if (listaDeCpsDeAlunosMatriculados.contains(cpf)) {
            throw new IllegalArgumentException("Cpf Já possui matricula no curso!");
        }
    }

    public void verificaSeCursoPossuiVagasDisponiveis(int vagas) {
        if (listaDeCpsDeAlunosMatriculados.size() >= vagas) {
            throw new IllegalArgumentException("Curso não possui vagas disponíveis!");
        }
    }
}
