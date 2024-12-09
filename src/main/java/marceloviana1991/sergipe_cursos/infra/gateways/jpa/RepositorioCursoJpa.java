package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoRepository;

import java.util.List;

public class RepositorioCursoJpa implements RepositorioCurso {

    private final CursoRepository repositorio;
    private final MapperCurso mapper;

    public RepositorioCursoJpa(CursoRepository repositorio, MapperCurso mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    @Override
    public CursoResponseDto cadastrarCurso(String nome, String descricao, Integer vagas) {
        Curso curso = new Curso(nome, descricao, vagas);
        CursoEntity entity = new CursoEntity(curso);
        repositorio.save(entity);
        return mapper.response(entity);
    }

    @Override
    public List<CursoResponseDto> listarCursos() {
        List<CursoEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(mapper::response)
                .toList();
    }

    @Override
    public CursoResponseDto detalharCurso(String id) {
        CursoEntity entity = repositorio.getReferenceById(id);
        return mapper.response(entity);
    }

    @Override
    public void excluirCurso(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public CursoResponseDto atualizarCurso(String id, String nome, String descricao, Integer vagas) {
        Curso curso = new Curso();
        curso.validacaoVagas(vagas);
        CursoEntity entity = repositorio.getReferenceById(id);
        entity.atualizar(nome, descricao, vagas);
        return mapper.response(entity);
    }
}
