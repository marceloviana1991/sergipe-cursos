package marceloviana1991.sergipe_cursos.config;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.CadastroMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.ListagemMatricula;
import marceloviana1991.sergipe_cursos.infra.gateways.*;
import marceloviana1991.sergipe_cursos.infra.persistence.MatriculaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatriculaConfig {

    @Bean
    public CadastroMatricula cadastrarMatricula(RepositorioMatricula repositorioMatricula) {
        return new CadastroMatricula(repositorioMatricula);
    }

    @Bean
    public ListagemMatricula listarMatriculas(RepositorioMatricula repositorioMatricula) {
        return new ListagemMatricula(repositorioMatricula);
    }

    @Bean
    public RepositorioMatriculaJpa repositorioMatriculaJpa(
            MatriculaRepository matriculaRepository,
            MatriculaEntityMapper matriculaEntityMapper
    ) {
        return new RepositorioMatriculaJpa(matriculaRepository, matriculaEntityMapper);
    }

    @Bean
    public MatriculaEntityMapper matriculaEntityMapper(
            AlunoEntityMapper alunoEntityMapper,
            CursoEntityMapper cursoEntityMapper
    ) {
        return new MatriculaEntityMapper(alunoEntityMapper, cursoEntityMapper);
    }
}
