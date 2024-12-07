package marceloviana1991.sergipe_cursos.config;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.application.usecases.curso.*;
import marceloviana1991.sergipe_cursos.infra.gateways.CursoEntityMapper;
import marceloviana1991.sergipe_cursos.infra.gateways.RepositorioCursoJpa;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CursoConfig {

    @Bean
    public CadastroCurso cadastrarCurso(RepositorioCurso repositorioCurso) {
        return new CadastroCurso(repositorioCurso);
    }

    @Bean
    public ListagemCurso listarCursos(RepositorioCurso repositorioCurso) {
        return new ListagemCurso(repositorioCurso);
    }

    @Bean
    public DetalhamentoCurso detalharCurso(RepositorioCurso repositorioCurso) {
        return new DetalhamentoCurso(repositorioCurso);
    }

    @Bean
    public ExclusaoCurso excluirCurso(RepositorioCurso repositorioCurso) {
        return new ExclusaoCurso(repositorioCurso);
    }

    @Bean
    public AtualizacaoCurso atualizarCurso(RepositorioCurso repositorioCurso) {
        return new AtualizacaoCurso(repositorioCurso);
    }

    @Bean
    public RepositorioCursoJpa repositorioCursoJpa(CursoRepository cursoRepository) {
        return new RepositorioCursoJpa(cursoRepository);
    }

    @Bean
    public CursoEntityMapper cursoEntityMapper() {
        return new CursoEntityMapper();
    }

}