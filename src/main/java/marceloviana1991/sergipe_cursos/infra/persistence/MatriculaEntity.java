package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;
import marceloviana1991.sergipe_cursos.domain.Matricula;

@Entity
@Table(name = "Matriculas")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AlunoEntity aluno;
    @ManyToOne
    private CursoEntity curso;

    public MatriculaEntity() {}

    public MatriculaEntity(AlunoEntity aluno, CursoEntity curso) {
        if (curso.getVagas() == 0) {
            throw new IllegalArgumentException("Curso não possui vaga disponível!");
        }
        curso.preencherVaga();
        this.aluno = aluno;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
