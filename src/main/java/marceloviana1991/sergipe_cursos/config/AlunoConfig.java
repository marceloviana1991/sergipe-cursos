package marceloviana1991.sergipe_cursos.config;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.application.usecases.*;
import marceloviana1991.sergipe_cursos.infra.gateways.AlunoEntityMapper;
import marceloviana1991.sergipe_cursos.infra.gateways.RepositorioAlunoJpa;
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
    public RepositorioAlunoJpa cadastrarAlunoJpa(AlunoRepository repository, AlunoEntityMapper mapper) {
        return new RepositorioAlunoJpa(repository, mapper);
    }

    @Bean
    public AlunoEntityMapper retornaMapper() {
        return new AlunoEntityMapper();
    }
}
