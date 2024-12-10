package marceloviana1991.sergipe_cursos.domain;

import java.util.List;

public class Matricula {
    private String idAluno;
    private String idCurso;

    public Matricula(String idAluno, String idCurso, List<String> listaDeAlunosMatriculados,
                     Integer vagasDisponives) {
        verificaSeAlunoJaPossuiMatricula(listaDeAlunosMatriculados);
        verificaSeCursoPossuiVagaDisponivel(vagasDisponives);
        this.idAluno = idAluno;
        this.idCurso = idCurso;
    }

    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    private void verificaSeAlunoJaPossuiMatricula(List<String> listaDeAlunosMatriculados) {
        for(String idAlunoMatriculado: listaDeAlunosMatriculados) {
            if (idAlunoMatriculado.equals(this.idAluno)) {
                throw new IllegalArgumentException("Aluno já possui matricula no curso!");
            }
        }
    }
    private void verificaSeCursoPossuiVagaDisponivel(Integer vagasDisponives) {
        if (vagasDisponives <= 0) {
            throw new IllegalArgumentException("Curso não possui vaga disponível!");
        }
    }
}
