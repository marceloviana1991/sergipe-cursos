package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoRepository;

import java.time.LocalDate;
import java.util.List;

public class RepositorioAlunoJpa implements RepositorioAluno {

    private final AlunoRepository repositorio;
    private final MapperAluno mapper;

    public RepositorioAlunoJpa(AlunoRepository repositorio, MapperAluno mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    @Override
    public AlunoResponseDto cadastrarAluno(String cpf, String nome, LocalDate nascimento, String email) {
        List<String> listaDeCpfsCadastrados = repositorio.cpfsDeAlunosCadastrados(cpf);
        List<String> listaDeEmailsCadastrados = repositorio.emailsDeAlunosCadastrados(email);
        Aluno aluno = new Aluno(cpf, nome, nascimento, email, listaDeCpfsCadastrados, listaDeEmailsCadastrados);
        AlunoEntity entity = new AlunoEntity(aluno);
        repositorio.save(entity);
        return mapper.response(entity);
    }

    @Override
    public List<AlunoResponseDto> listarAlunos() {
        List<AlunoEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(mapper::response)
                .toList();
    }

    @Override
    public AlunoResponseDto detalharAluno(String id) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        return mapper.response(entity);
    }

    @Override
    public void excluirAluno(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public AlunoResponseDto atualizarAluno(String id,  String cpf, String nome, LocalDate nascimento, String email) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        Aluno aluno = new Aluno();
        if(cpf != null) {
            aluno.validacaoCPF(cpf);
        }
        if(email != null) {
            aluno.validacaoEmail(email);
        }
        entity.atualizar(cpf, nome, nascimento, email);
        return mapper.response(entity);
    }


}
