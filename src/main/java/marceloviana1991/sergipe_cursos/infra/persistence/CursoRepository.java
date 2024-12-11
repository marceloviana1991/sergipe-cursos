package marceloviana1991.sergipe_cursos.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<CursoEntity, String> {
    @Query("SELECT c.vagas FROM CursoEntity c WHERE c.id = :cursoId")
    Integer quantidadeDeVagasNoCurso(String cursoId);
}
