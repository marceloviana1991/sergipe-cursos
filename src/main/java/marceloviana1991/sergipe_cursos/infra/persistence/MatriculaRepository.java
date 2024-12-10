package marceloviana1991.sergipe_cursos.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, String> {
    @Query("SELECT m.alunoEntity.id FROM MatriculaEntity m WHERE m.cursoEntity.id = :cursoId")
    List<String> alunosMatriculadosPorCurso(String cursoId);
}
