package marceloviana1991.sergipe_cursos.aplication;

import marceloviana1991.sergipe_cursos.domain.Matricula;

import java.util.List;

public interface GatewayMatricula {
    Matricula cadastrar(String cpfAluno, String turmaCurso);
    List<Matricula> listar();
}
