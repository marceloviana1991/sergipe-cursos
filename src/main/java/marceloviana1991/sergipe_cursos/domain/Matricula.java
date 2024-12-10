package marceloviana1991.sergipe_cursos.domain;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public class Matricula {
    private String idAluno;
    private String idCurso;

    public Matricula(String idAluno, String idCurso, List<String> listaDeAlunosMatriculados, Integer vagasDisponives) {
        String uuid = UUID.randomUUID().toString();
        if (idAluno == null || uuid.length() != idAluno.length()) {
            throw new EntityNotFoundException();
        }
        if (idCurso == null || uuid.length() != idCurso.length()) {
            throw new EntityNotFoundException();
        }
        this.idAluno = idAluno;
        this.idCurso = idCurso;
        verificaSeAlunoJaPossuiMatricula(listaDeAlunosMatriculados);
        verificaSeCursoPossuiVagaDisponivel(vagasDisponives);
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
        if (listaDeAlunosMatriculados.contains(this.idAluno)) {
            throw new IllegalArgumentException("Aluno já possui matricula no curso!");
        }
    }

    private void verificaSeCursoPossuiVagaDisponivel(Integer vagasDisponives) {
        if (vagasDisponives <= 0) {
            throw new IllegalArgumentException("Curso não possui vaga disponível!");
        }
    }

}
