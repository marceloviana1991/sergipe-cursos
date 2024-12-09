package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "Matriculas")
public class MatriculaEntity {
    @Id
    private String id;
    @ManyToOne
    private AlunoEntity aluno;
    @ManyToOne
    private CursoEntity curso;

    public MatriculaEntity() {}

    public MatriculaEntity(String id, AlunoEntity aluno, CursoEntity curso) {
        curso.preencherVaga();
        this.id = id;
        this.aluno = aluno;
        this.curso = curso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }
}
