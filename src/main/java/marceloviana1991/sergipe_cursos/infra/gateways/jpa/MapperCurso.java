package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;

public class MapperCurso {

    public Curso request(CursoRequestDto requestDto) {
        return new Curso(requestDto.nome(), requestDto.descricao(), requestDto.vagas());
    }

    public CursoResponseDto response(CursoEntity entity) {
        return new CursoResponseDto(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas());
    }
}
