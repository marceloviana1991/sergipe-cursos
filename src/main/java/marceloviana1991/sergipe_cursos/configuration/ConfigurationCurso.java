package marceloviana1991.sergipe_cursos.configuration;

import marceloviana1991.sergipe_cursos.aplication.GatewayCurso;
import marceloviana1991.sergipe_cursos.aplication.UseCasesCurso;
import marceloviana1991.sergipe_cursos.infra.orm.CursoRepository;
import marceloviana1991.sergipe_cursos.infra.service.CursoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationCurso {

    @Bean
    public UseCasesCurso useCasesCurso(GatewayCurso gatewayCurso) {
        return new UseCasesCurso(gatewayCurso);
    }

    @Bean
    public CursoService cursoService(CursoRepository cursoRepository) {
        return new CursoService(cursoRepository);
    }
}
