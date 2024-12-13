package marceloviana1991.sergipe_cursos.infra.orm;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity, String> {
    List<CursoEntity> findAllByAtivoTrue();
}
