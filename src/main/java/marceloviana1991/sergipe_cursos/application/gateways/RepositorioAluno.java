package marceloviana1991.sergipe_cursos.application.gateways;

import marceloviana1991.sergipe_cursos.domain.entities.Aluno;

import java.util.List;

public interface RepositorioAluno {
    Aluno cadastrarAluno(Aluno aluno);
    List<Aluno> listarAlunos();
    Aluno detalharAluno(Long id);
    void excluirAluno(Long id);
}
