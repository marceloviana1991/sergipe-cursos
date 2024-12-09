package marceloviana1991.sergipe_cursos.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, String> {
    List<MatriculaEntity> findAllByAluno(AlunoEntity alunoEntity);
}
