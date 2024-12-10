package marceloviana1991.sergipe_cursos.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<AlunoEntity, String> {
    @Query("SELECT a.cpf FROM AlunoEntity a WHERE a.cpf = :cpf")
    List<String> cpfsDeAlunosCadastrados(String cpf);

    @Query("SELECT a.email FROM AlunoEntity a WHERE a.email = :email")
    List<String> emailsDeAlunosCadastrados(String email);
}
