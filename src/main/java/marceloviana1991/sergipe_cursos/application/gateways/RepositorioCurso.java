package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.domain.Curso;

import java.util.List;

public interface RepositorioCurso {
    Curso cadastrarCurso(Curso curso);
    List<Curso> listarCursos();
    Curso detalharCurso(Long id);
    void excluirCurso(Long id);
    Curso atualizarCurso(Long id, Curso curso);
}
