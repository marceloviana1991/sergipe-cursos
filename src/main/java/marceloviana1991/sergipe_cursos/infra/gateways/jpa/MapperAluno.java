package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;

public class MapperAluno {

    public AlunoResponseDto response(AlunoEntity entity) {
        return new AlunoResponseDto(
                entity.getId(), entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }
}
