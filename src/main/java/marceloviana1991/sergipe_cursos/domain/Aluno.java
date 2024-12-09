package marceloviana1991.sergipe_cursos.domain;

import java.time.LocalDate;

public class Aluno {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public Aluno(String cpf, String nome, LocalDate nascimento, String email) {
        this.validacaoCPF(cpf);
        this.validacaoEmail(email);
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

    public void setCpf(String cpf) {
        if(cpf != null) {
            this.validacaoCPF(cpf);
            this.cpf = cpf;
        }
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

    public void setEmail(String email) {
        if(email != null) {
            this.validacaoEmail(email);
            this.email = email;
        }
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
}
