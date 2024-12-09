package marceloviana1991.sergipe_cursos.config;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.application.usecases.aluno.*;
import marceloviana1991.sergipe_cursos.infra.gateways.jpa.MapperAluno;
import marceloviana1991.sergipe_cursos.infra.gateways.jpa.RepositorioAlunoJpa;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunoConfig {

    @Bean
    public CadastroAluno cadastrarAluno(RepositorioAluno repositorioAluno) {
        return new CadastroAluno(repositorioAluno);
    }

    @Bean
    public ListagemAluno listarAlunos(RepositorioAluno repositorioAluno) {
        return new ListagemAluno(repositorioAluno);
    }

    @Bean
    public DetalhamentoAluno detalharAluno(RepositorioAluno repositorioAluno) {
        return new DetalhamentoAluno(repositorioAluno);
    }

    @Bean
    public ExclusaoAluno excuirAluno(RepositorioAluno repositorioAluno) {
        return new ExclusaoAluno(repositorioAluno);
    }

    @Bean
    public AtualizacaoAluno atualizarAluno(RepositorioAluno repositorioAluno) {
        return new AtualizacaoAluno(repositorioAluno);
    }

    @Bean
    public RepositorioAlunoJpa repositorioAlunoJpa(AlunoRepository repository, MapperAluno mapper) {
        return new RepositorioAlunoJpa(repository, mapper);
    }

    @Bean
    public MapperAluno mapperAluno(){
        return new MapperAluno();
    }

}
