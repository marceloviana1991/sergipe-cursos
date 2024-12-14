package marceloviana1991.sergipe_cursos.domain;

public class Matricula {
    private String cpfAluno;
    private String turmaCurso;

    public Matricula(String cpfAluno, String turmaCurso) {
        validacaoCpfAluno(cpfAluno);
        validacaoTurmaCurso(turmaCurso);
        this.cpfAluno = cpfAluno;
        this.turmaCurso = turmaCurso;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public String getTurmaCurso() {
        return turmaCurso;
    }

    public void setTurmaCurso(String turmaCurso) {
        this.turmaCurso = turmaCurso;
    }

    private void validacaoCpfAluno(String cpfAluno) {
        if (cpfAluno.isEmpty() || cpfAluno.isBlank()) {
            throw new IllegalArgumentException("cpfAluno nulo ou em branco!");
        }
    }

    private void validacaoTurmaCurso(String turmaCurso) {
        if (turmaCurso.isBlank() || turmaCurso.isEmpty()) {
            throw new IllegalArgumentException("turmaCurso nulo ou em branco!");
        }
    }
}
