package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "Matriculas")
public class MatriculaEntity {

    @EmbeddedId
    private MatriculaKey matriculaKey = new MatriculaKey();

    public MatriculaEntity() {}

    public MatriculaEntity(String alunoId, String cursoId, CursoEntity cursoEntity) {
        this.matriculaKey.setAlunoId(alunoId);
        this.matriculaKey.setCursoId(cursoId);
        cursoEntity.preencherVaga();
    }


    public MatriculaKey getMatriculaKey() {
        return matriculaKey;
    }

    public void setMatriculaKey(MatriculaKey matriculaKey) {
        this.matriculaKey = matriculaKey;
    }
}
