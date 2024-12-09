package marceloviana1991.sergipe_cursos.domain;

public class Curso {
    private String nome;
    private String descricao;
    private Integer vagas;

    public Curso(String nome, String descricao, Integer vagas) {
        this.nome = nome;
        this.descricao = descricao;
        this.vagas = vagas;
    }

    public Curso() {
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

}
