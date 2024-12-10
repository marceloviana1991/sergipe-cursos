package marceloviana1991.sergipe_cursos.infra.persistence;

import jakarta.persistence.Embeddable;

@Embeddable
public class MatriculaKey {
    private String alunoId;
    private String cursoId;

    public MatriculaKey(String alunoId, String cursoId) {
        this.alunoId = alunoId;
        this.cursoId = cursoId;
    }

    public MatriculaKey() {

    }

    public String getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(String alunoId) {
        this.alunoId = alunoId;
    }

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }
}
