package marceloviana1991.sergipe_cursos.domain;

import marceloviana1991.sergipe_cursos.infra.controller.AlunoDto;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;

import java.time.LocalDate;

public class Aluno {
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public Aluno(AlunoEntity entity) {
        this.id = entity.getId();
        this.cpf = entity.getCpf();
        this.nome = entity.getNome();
        this.nascimento = entity.getNascimento();
        this.email = entity.getEmail();
    }

    public Aluno(AlunoDto alunoDto) {
        if (alunoDto.cpf() == null || !alunoDto.cpf().matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
        if (alunoDto.email() == null ||
                !alunoDto.email().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("email no padrão incorreto!");
        }
        this.cpf = alunoDto.cpf();
        this.nome = alunoDto.nome();
        this.nascimento = alunoDto.nascimento();
        this.email = alunoDto.email();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        this.email = email;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
