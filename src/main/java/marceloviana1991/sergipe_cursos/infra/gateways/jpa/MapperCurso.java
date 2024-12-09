package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;

public class MapperCurso {

    public CursoResponseDto response(CursoEntity entity) {
        return new CursoResponseDto(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas());
    }

}
