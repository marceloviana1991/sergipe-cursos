package marceloviana1991.sergipe_cursos.domain;

import java.util.UUID;

public class Curso {
    private final UUID uuid;
    private String nome;
    private String descricao;
    private Integer vagas;

    public Curso(String nome, String descricao, Integer vagas) {
        this.uuid = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.vagas = vagas;
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

    public UUID getUuid() {
        return uuid;
    }

    public void validacaoVagas(Integer vagas) {
        if (vagas == null || vagas <= 0) {
            throw new IllegalArgumentException("Quantidade de vagas inválida!");
        }
    }

}
