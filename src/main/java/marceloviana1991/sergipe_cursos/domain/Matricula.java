package marceloviana1991.sergipe_cursos.domain;

import java.util.List;
import java.util.UUID;

public class Matricula {
    private UUID uuid;
    private String idAluno;
    private String idCurso;

    public Matricula(String idAluno, String idCurso, List<String> idsDosAlunosJaMatriculados,
                     Integer vagasDisponives) {
        verificaSeAlunoJaPossuiMatricula(idsDosAlunosJaMatriculados);
        verificaSeCursoPossuiVagaDisponivel(vagasDisponives);
        this.uuid = UUID.randomUUID();
        this.idAluno = idAluno;
        this.idCurso = idCurso;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    private void verificaSeAlunoJaPossuiMatricula(List<String> idsDosAlunosJaMatriculados) {
        for(String idAlunoMatriculado: idsDosAlunosJaMatriculados) {
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
