package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;
import marceloviana1991.sergipe_cursos.domain.Curso;

@Entity
@Table(name = "Cursos")
public class CursoEntity {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Integer vagas;

    public CursoEntity() {}

    public CursoEntity(Curso curso) {
        this.id = curso.getUuid().toString();
        this.nome = curso.getNome();
        this.descricao = curso.getDescricao();
        this.vagas = curso.getVagas();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void atualizar(String nome, String descricao, Integer vagas) {
        if (nome != null) {this.nome = nome;}
        if (descricao != null) {this.descricao = descricao;}
        if (vagas != null) {this.vagas = vagas;}
    }

    public void preencherVaga() {
        this.vagas -= 1;
    }
}
