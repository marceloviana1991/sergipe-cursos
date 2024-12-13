package marceloviana1991.sergipe_cursos.aplication;

import marceloviana1991.sergipe_cursos.domain.Curso;

import java.util.List;

public interface GatewayCurso {
    Curso cadastrar(String nome, int vagas);
    List<Curso> listarAtivos();
    void atualizarDados(String turma, String nome, Integer vagas);
    void desativar(String turma);
}
