package marceloviana1991.sergipe_cursos.domain;

public class Aluno {
    private String cpf;
    private String nome;
    private String email;

    public Aluno(String cpf, String nome, String email) {
        this.validacaoCPF(cpf);
        this.validacaoEmail(email);
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    private void validacaoCPF(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
        }
    }

    private void validacaoEmail(String email) {
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("email no padrão incorreto!");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
