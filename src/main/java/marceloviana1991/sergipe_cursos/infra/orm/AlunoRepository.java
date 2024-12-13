package marceloviana1991.sergipe_cursos.infra.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<AlunoEntity, String> {
    @Query("SELECT a.cpf FROM AlunoEntity a")
    List<String> findAllCpfs();

    @Query("SELECT a.email FROM AlunoEntity a")
    List<String> findAllEmails();
}
