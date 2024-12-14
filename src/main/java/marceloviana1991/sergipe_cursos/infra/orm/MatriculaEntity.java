package marceloviana1991.sergipe_cursos.infra.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "Matriculas")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AlunoEntity alunoEntity;
    @ManyToOne
    private CursoEntity cursoEntity;

    public MatriculaEntity() {
    }

    public MatriculaEntity(AlunoEntity alunoEntity, CursoEntity cursoEntity) {
        this.alunoEntity = alunoEntity;
        this.cursoEntity = cursoEntity;
    }

    public CursoEntity getCursoEntity() {
        return cursoEntity;
    }

    public void setCursoEntity(CursoEntity cursoEntity) {
        this.cursoEntity = cursoEntity;
    }

    public AlunoEntity getAlunoEntity() {
        return alunoEntity;
    }

    public void setAlunoEntity(AlunoEntity alunoEntity) {
        this.alunoEntity = alunoEntity;
    }
}
