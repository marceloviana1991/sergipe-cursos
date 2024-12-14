package marceloviana1991.sergipe_cursos.infra.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long> {
    @Query("SELECT m.alunoEntity.cpf FROM MatriculaEntity m WHERE m.cursoEntity.turma = :turmaCurso")
    List<String> listaDeCpsDeAlunosMatriculados(String turmaCurso);
}
