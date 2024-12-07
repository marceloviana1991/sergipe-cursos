package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;
import marceloviana1991.sergipe_cursos.domain.entities.Aluno;

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
        this.email = aluno.getEmail();
        this.cpf = aluno.getCpf();
        this.nome = aluno.getNome();
        this.nascimento = aluno.getNascimento();
        this.email = aluno.getEmail();
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

}
