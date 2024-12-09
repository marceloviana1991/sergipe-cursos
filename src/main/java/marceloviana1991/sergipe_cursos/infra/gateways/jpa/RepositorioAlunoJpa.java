package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoRepository;

import java.util.List;

public class RepositorioAlunoJpa implements RepositorioAluno {

    private final AlunoRepository repositorio;
    private final MapperAluno mapper;

    public RepositorioAlunoJpa(AlunoRepository repositorio, MapperAluno mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    @Override
    public AlunoResponseDto cadastrarAluno(AlunoRequestDto requestDto) {
        Aluno aluno = mapper.request(requestDto);
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
    public AlunoResponseDto detalharAluno(Long id) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        return mapper.response(entity);
    }

    @Override
    public void excluirAluno(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public AlunoResponseDto atualizarAluno(Long id, AlunoRequestDto requestDto) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        Aluno aluno = mapper.atualizar(requestDto);
        entity.atualizar(aluno);
        return mapper.response(entity);
    }


}
