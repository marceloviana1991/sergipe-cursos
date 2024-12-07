package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;

public class CursoEntityMapper {

    public CursoEntity toEntity(Curso curso) {
        return new CursoEntity(curso);
    }

    public Curso toDomain(CursoEntity entity) {
        return new Curso(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas());
    }
}
