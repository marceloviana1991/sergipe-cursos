package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;

public class MapperAluno {

    public Aluno request(AlunoRequestDto requestDto) {
        return new Aluno(requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email());
    }

    public AlunoResponseDto response(AlunoEntity entity) {
        return new AlunoResponseDto(
                entity.getId(), entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }
}
