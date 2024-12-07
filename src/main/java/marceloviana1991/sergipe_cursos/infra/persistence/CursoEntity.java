package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;
import marceloviana1991.sergipe_cursos.domain.Curso;

@Entity
@Table(name = "Cursos")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Integer vagas;

    public CursoEntity() {}

    public CursoEntity(Curso curso) {
        this.nome = curso.getNome();
        this.descricao = curso.getDescricao();
        this.vagas = curso.getVagas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void atualizar(Curso curso) {
        if (curso.getNome() != null) {this.nome = curso.getNome();}
        if (curso.getDescricao() != null) {this.descricao = curso.getDescricao();}
        if (curso.getVagas() != null) {this.vagas = curso.getVagas();}
    }
}
