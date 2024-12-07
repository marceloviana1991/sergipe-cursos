package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.domain.entities.Aluno;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;

public class AlunoEntityMapper {

    public AlunoEntity toEntity(Aluno aluno) {
        return new AlunoEntity(aluno.getEmail(), aluno.getCpf(), aluno.getNome(), aluno.getNascimento());
    }

    public Aluno toDomain(AlunoEntity entity) {
        return new Aluno(entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }
}
