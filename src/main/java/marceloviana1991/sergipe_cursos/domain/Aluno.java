package marceloviana1991.sergipe_cursos.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Aluno {
    private final UUID uuid;
    private final String cpf;
    private String nome;
    private LocalDate nascimento;
    private final String email;

    public Aluno(String cpf, String nome, LocalDate nascimento, String email) {
        this.validacaoCPF(cpf);
        this.validacaoEmail(email);
        this.uuid = UUID.randomUUID();
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    private void validacaoCPF(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
    }

    private void validacaoEmail(String email) {
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("email no padrão incorreto!");
        }
    }

    public void verificaSeJaPossuiCpfCadastrado(List<String> listaDeCpfsCadastrados) {
        if (listaDeCpfsCadastrados.contains(this.cpf)) {
            throw new IllegalArgumentException("Já possui cadastro com esse cpf!");
        }
    }

    public void verificaSeJaPossuiEmailCadastrado(List<String> listaDeEmailsCadastrados) {
        if (listaDeEmailsCadastrados.contains(this.email)) {
            throw new IllegalArgumentException("Já possui cadastro com esse email!");
        }
    }

    public UUID getUuid() {
        return uuid;
    }

}
