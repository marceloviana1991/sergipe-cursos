package marceloviana1991.sergipe_cursos.aplication;

import marceloviana1991.sergipe_cursos.domain.Curso;

import java.util.List;

public class UseCasesCurso {
    private final GatewayCurso gatewayCurso;

    public UseCasesCurso(GatewayCurso gatewayCurso) {
        this.gatewayCurso = gatewayCurso;
    }

    public Curso cadastrar(String nome, int vagas) {
        return gatewayCurso.cadastrar(nome, vagas);
    }

    public List<Curso> listar() {
        return gatewayCurso.listar();
    }

    public void atualizarDados(String turma, String nome, Integer vagas) {
        gatewayCurso.atualizarDados(turma, nome, vagas);
    }

    public void desativar(String turma) {
        gatewayCurso.desativar(turma);
    }
}
