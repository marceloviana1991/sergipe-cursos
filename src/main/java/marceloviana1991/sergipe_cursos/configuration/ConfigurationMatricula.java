package marceloviana1991.sergipe_cursos.configuration;

import marceloviana1991.sergipe_cursos.aplication.GatewayMatricula;
import marceloviana1991.sergipe_cursos.aplication.UseCasesMatricula;
import marceloviana1991.sergipe_cursos.infra.orm.AlunoRepository;
import marceloviana1991.sergipe_cursos.infra.orm.CursoRepository;
import marceloviana1991.sergipe_cursos.infra.orm.MatriculaRepository;
import marceloviana1991.sergipe_cursos.infra.service.MatriculaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMatricula {

    @Bean
    public UseCasesMatricula useCasesMatricula(GatewayMatricula gatewayMatricula) {
        return new UseCasesMatricula(gatewayMatricula);
    }

    @Bean
    public MatriculaService matriculaService(MatriculaRepository matriculaRepository,
                                             AlunoRepository alunoRepository,
                                             CursoRepository cursoRepository) {
        return new MatriculaService(matriculaRepository, alunoRepository, cursoRepository);
    }
}
