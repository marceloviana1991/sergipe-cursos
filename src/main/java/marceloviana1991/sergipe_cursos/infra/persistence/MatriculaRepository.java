package marceloviana1991.sergipe_cursos.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, MatriculaKey> {
    @Query("SELECT m.matriculaKey.alunoId FROM MatriculaEntity m WHERE m.matriculaKey.cursoId = :cursoId")
    List<String> alunosMatriculadosPorCurso(String cursoId);
}
