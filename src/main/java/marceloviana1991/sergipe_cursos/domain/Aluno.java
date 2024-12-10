package marceloviana1991.sergipe_cursos.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Aluno {
    private UUID uuid;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public Aluno(String cpf, String nome, LocalDate nascimento, String email, List<String> listaDeCpfsCadastrados,
                 List<String> listaDeEmailsCadastrados) {
        verificaSeJaPossuiCpfCadastrado(listaDeCpfsCadastrados, cpf);
        verificaSeJaPossuiEmailCadastrado(listaDeEmailsCadastrados, email);
        this.validacaoCPF(cpf);
        this.validacaoEmail(email);
        this.uuid = UUID.randomUUID();
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Aluno() {
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


    public void validacaoCPF(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
    }

    public void validacaoEmail(String email) {
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("email no padrão incorreto!");
        }
    }

    private void verificaSeJaPossuiCpfCadastrado(List<String> listaDeCpfsCadastrados, String cpf) {
        if (listaDeCpfsCadastrados.contains(cpf)) {
            throw new IllegalArgumentException("Já possui cadastro com esse cpf!");
        }
    }

    private void verificaSeJaPossuiEmailCadastrado(List<String> listaDeEmailsCadastrados, String email) {
        if (listaDeEmailsCadastrados.contains(email)) {
            throw new IllegalArgumentException("Já possui cadastro com esse email!");
        }
    }

    public UUID getUuid() {
        return uuid;
    }

}
