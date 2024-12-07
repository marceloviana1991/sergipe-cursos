package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoRepository;

import java.util.List;

public class RepositorioAlunoJpa implements RepositorioAluno {

    private final AlunoRepository repositorio;
    private final AlunoEntityMapper mapper;

    public RepositorioAlunoJpa(AlunoRepository repositorio, AlunoEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        AlunoEntity entity = mapper.toEntity(aluno);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Aluno> listarAlunos() {
        List<AlunoEntity> entityList = repositorio.findAll();
        return entityList.stream().map(mapper::toDomain).toList();
    }

    @Override
    public Aluno detalharAluno(Long id) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirAluno(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Aluno atualizarAluno(Long id, Aluno aluno) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        entity.atualizar(aluno);
        return mapper.toDomain(entity);
    }


}
