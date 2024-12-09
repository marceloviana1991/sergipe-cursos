package marceloviana1991.sergipe_cursos.infra.gateways.jpa;


import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
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
    public CursoResponseDto cadastrarCurso(CursoRequestDto requestDto) {
        Curso curso = mapper.request(requestDto);
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
    public CursoResponseDto detalharCurso(Long id) {
        CursoEntity entity = repositorio.getReferenceById(id);
        return mapper.response(entity);
    }

    @Override
    public void excluirCurso(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public CursoResponseDto atualizarCurso(Long id, CursoRequestDto requestDto) {
        Curso curso = mapper.atualizar(requestDto);
        CursoEntity entity = repositorio.getReferenceById(id);
        entity.atualizar(curso);
        return mapper.response(entity);
    }
}
