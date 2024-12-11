package marceloviana1991.sergipe_cursos.config;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.CadastroMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.ListagemAlunosMatriculados;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.ListagemMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.VerificaQuantidadeDeVagasDisponiveis;
import marceloviana1991.sergipe_cursos.infra.gateways.jpa.RepositorioMatriculaJpa;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoRepository;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoRepository;
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
    public ListagemAlunosMatriculados listarAlunosMatriculados(RepositorioMatricula repositorioMatricula) {
        return new ListagemAlunosMatriculados(repositorioMatricula);
    }

    @Bean
    public VerificaQuantidadeDeVagasDisponiveis verificarQuantidadeDeVagasDisponiveis(
            RepositorioMatricula repositorioMatricula) {
        return new VerificaQuantidadeDeVagasDisponiveis(repositorioMatricula);
    }
    @Bean
    public RepositorioMatriculaJpa repositorioMatriculaJpa(
            MatriculaRepository matriculaRepository,
            AlunoRepository alunoRepository,
            CursoRepository cursoRepository
    ) {
        return new RepositorioMatriculaJpa(matriculaRepository, alunoRepository, cursoRepository);
    }

}
