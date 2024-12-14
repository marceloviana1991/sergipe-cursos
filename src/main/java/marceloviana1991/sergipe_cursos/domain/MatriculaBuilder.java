package marceloviana1991.sergipe_cursos.domain;

import java.util.List;

public class MatriculaBuilder {
    private final List<String> listaDeCpfsDeAlunosMatriculados;
    private final List<String> listaDeTodosCpfsCadastrados;
    private final List<String> listaDeTodasTurmasCadastradasAtivas;

    public MatriculaBuilder(List<String> listaDeCpsDeAlunosMatriculados,
                            List<String> listaDeTodosCpfsCadastrados,
                            List<String> listaDeTodasTurmasCadastradasAtivas) {
        this.listaDeCpfsDeAlunosMatriculados = listaDeCpsDeAlunosMatriculados;
        this.listaDeTodosCpfsCadastrados = listaDeTodosCpfsCadastrados;
        this.listaDeTodasTurmasCadastradasAtivas = listaDeTodasTurmasCadastradasAtivas;
    }

    public Matricula createMatricula(String cfpAluno, String turmaCurso) {
        return new Matricula(cfpAluno, turmaCurso);
    }

    public void verificaSeAlunoJaPossuiMatriculaNoCurso(String cpf) {
        if (listaDeCpfsDeAlunosMatriculados.contains(cpf)) {
            throw new IllegalArgumentException("Cpf Já possui matricula no curso!");
        }
    }

    public void verificaSeCursoPossuiVagasDisponiveis(int vagas) {
        if (listaDeCpfsDeAlunosMatriculados.size() >= vagas) {
            throw new IllegalArgumentException("Curso não possui vagas disponíveis!");
        }
    }

    public void verificaSeExisteCpfCadastrado(String cpf) {
        if (!listaDeTodosCpfsCadastrados.contains(cpf)) {
            throw new IllegalArgumentException("Cpf inválido!");
        }
    }

    public void verificaSeExisteTurmaAtivaCadastrada(String turma) {
        if (!listaDeTodasTurmasCadastradasAtivas.contains(turma)) {
            throw new IllegalArgumentException("Turma inválido!");
        }
    }
}
