package marceloviana1991.sergipe_cursos.infra.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity, String> {
    List<CursoEntity> findAllByAtivoTrue();

    @Query("SELECT c.turma FROM CursoEntity c WHERE c.ativo = true")
    List<String> findAllTurmaByAtivoTrue();
}
