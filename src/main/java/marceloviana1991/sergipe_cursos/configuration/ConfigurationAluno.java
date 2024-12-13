package marceloviana1991.sergipe_cursos.configuration;

import marceloviana1991.sergipe_cursos.aplication.GatewayAluno;
import marceloviana1991.sergipe_cursos.aplication.UseCasesAluno;
import marceloviana1991.sergipe_cursos.infra.orm.AlunoRepository;
import marceloviana1991.sergipe_cursos.infra.service.AlunoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationAluno {

    @Bean
    public UseCasesAluno useCasesAluno(GatewayAluno gatewayAluno) {
        return new UseCasesAluno(gatewayAluno);
    }

    @Bean
    public AlunoService alunoService(AlunoRepository alunoRepository) {
        return new AlunoService(alunoRepository);
    }
}
