package marceloviana1991.sergipe_cursos.domain;

import java.util.List;

public class AlunoBuilder {
    private final List<String> listaDeCpfsCadastrados;
    private final List<String> listaDeEmailsCadastrados;

    public AlunoBuilder(List<String> listaDeCpfsCadastrados, List<String> listaDeEmailsCadastrados) {
        this.listaDeCpfsCadastrados = listaDeCpfsCadastrados;
        this.listaDeEmailsCadastrados = listaDeEmailsCadastrados;
    }

    public Aluno createAluno(String cpf, String nome, String email) {
        verificaSeJaPossuiCpfCadastrado(cpf);
        verificaSeJaPossuiEmailCadastrado(email);
        return new Aluno(cpf, nome, email);
    }

    public void verificaSeJaPossuiCpfCadastrado(String cpf) {
        if (this.listaDeCpfsCadastrados.contains(cpf)) {
            throw new IllegalArgumentException("Já possui cadastro com esse cpf!");
        }
    }

    public void verificaSeJaPossuiEmailCadastrado(String email) {
        if (this.listaDeEmailsCadastrados.contains(email)) {
            throw new IllegalArgumentException("Já possui cadastro com esse email!");
        }
    }
}
