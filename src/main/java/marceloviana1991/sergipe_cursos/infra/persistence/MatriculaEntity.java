package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "Matriculas")
public class MatriculaEntity {

    @Id
    private String id;
    @ManyToOne
    private AlunoEntity alunoEntity;
    @ManyToOne
    private CursoEntity cursoEntity;

    public MatriculaEntity() {}

    public MatriculaEntity(String id, AlunoEntity alunoEntity, CursoEntity cursoEntity) {
        this.id = id;
        this.alunoEntity = alunoEntity;
        this.cursoEntity = cursoEntity;
        cursoEntity.preencherVaga();
    }

    public AlunoEntity getAlunoEntity() {
        return alunoEntity;
    }

    public void setAlunoEntity(AlunoEntity alunoEntity) {
        this.alunoEntity = alunoEntity;
    }

    public CursoEntity getCursoEntity() {
        return cursoEntity;
    }

    public void setCursoEntity(CursoEntity cursoEntity) {
        this.cursoEntity = cursoEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
