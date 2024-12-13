package marceloviana1991.sergipe_cursos.aplication;

import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.util.List;

public class UseCasesAluno {
    private final GatewayAluno gateway;

    public UseCasesAluno(GatewayAluno gateway) {
        this.gateway = gateway;
    }

    public Aluno cadastrar(String cpf, String nome, String email) {
        return gateway.cadastrar(cpf, nome, email);
    }

    public List<Aluno> listar() {
        return gateway.listar();
    }

    public void atualizarDados(String cpf, String nome, String email) {
        gateway.atualizarDados(cpf, nome, email);
    }
}
