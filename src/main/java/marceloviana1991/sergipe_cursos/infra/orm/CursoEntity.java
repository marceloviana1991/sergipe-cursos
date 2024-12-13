package marceloviana1991.sergipe_cursos.infra.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cursos")
public class CursoEntity {
    @Id
    private String turma;
    private String nome;
    private Integer vagas;
    private boolean ativo;

    public CursoEntity() {
    }

    public CursoEntity(String turma, String nome,  int vagas, boolean ativo) {
        this.turma = turma;
        this.nome = nome;
        this.vagas = vagas;
        this.ativo = ativo;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
