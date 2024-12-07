package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;
import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.time.LocalDate;

@Entity
@Table(name = "Alunos")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public AlunoEntity() {}

    public AlunoEntity(Aluno aluno) {
        this.cpf = aluno.getCpf();
        this.nome = aluno.getNome();
        this.nascimento = aluno.getNascimento();
        this.email = aluno.getEmail();
    }

    public AlunoEntity(Long id, String cpf, String nome, LocalDate nascimento, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void atualizar(Aluno aluno) {
        if (aluno.getCpf() != null) {this.cpf = aluno.getCpf();}
        if (aluno.getNome() != null) {this.nome = aluno.getNome();}
        if (aluno.getNascimento() != null) {this.nascimento = aluno.getNascimento();}
        if (aluno.getEmail() != null) {this.email = aluno.getEmail();}
    }
}
