package marceloviana1991.sergipe_cursos.aplication;

import marceloviana1991.sergipe_cursos.domain.Matricula;

import java.util.List;

public class UseCasesMatricula {
    private final GatewayMatricula gatewayMatricula;

    public UseCasesMatricula(GatewayMatricula gatewayMatricula) {
        this.gatewayMatricula = gatewayMatricula;
    }

    public Matricula cadastrar(String cpfAluno, String turmaCurso) {
        return gatewayMatricula.cadastrar(cpfAluno, turmaCurso);
    }

    public List<Matricula> listar() {
        return gatewayMatricula.listar();
    }
}
