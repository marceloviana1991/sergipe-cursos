package marceloviana1991.sergipe_cursos.aplication;

import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.util.List;

public interface GatewayAluno {
    Aluno cadastrar(String cpf, String nome, String email);
    List<Aluno> listar();
    void atualizarDados(String cpf, String nome, String email);
}
