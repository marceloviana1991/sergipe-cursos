package marceloviana1991.sergipe_cursos.domain;

import java.util.UUID;

public class Curso {
    private String turma;
    private String nome;
    private int vagas;
    private final boolean ativo;

    public Curso(String nome, int vagas) {
        validacaoVagas(vagas);
        validacaoNome(nome);
        this.turma = UUID.randomUUID().toString();
        this.nome = nome;
        this.vagas = vagas;
        this.ativo = true;
    }

    public Curso(String turma, String nome, int vagas, boolean ativo) {
        this.turma = turma;
        this.nome = nome;
        this.vagas = vagas;
        this.ativo = ativo;
    }

    private void validacaoVagas(int vagas) {
        if (vagas <= 0) {
            throw new IllegalArgumentException("Quantidade de vagas inválida!");
        }
    }

    private void validacaoNome(String nome) {
        if (nome.isBlank() || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do curso inválido!");
        }
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


}
