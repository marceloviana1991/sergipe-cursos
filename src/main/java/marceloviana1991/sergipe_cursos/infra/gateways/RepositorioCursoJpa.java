package marceloviana1991.sergipe_cursos.infra.gateways;


import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoRepository;

import java.util.List;

public class RepositorioCursoJpa implements RepositorioCurso {

    private final CursoRepository repositorio;
    private final CursoEntityMapper mapper;

    public RepositorioCursoJpa(CursoRepository repositorio, CursoEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }


    @Override
    public Curso cadastrarCurso(Curso curso) {
        CursoEntity entity = mapper.toEntity(curso);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Curso> listarCursos() {
        List<CursoEntity> entityList = repositorio.findAll();
        return entityList.stream().map(mapper::toDomain).toList();
    }

    @Override
    public Curso detalharCurso(Long id) {
        CursoEntity entity = repositorio.getReferenceById(id);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirCurso(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Curso atualizarCurso(Long id, Curso curso) {
        CursoEntity entity = repositorio.getReferenceById(id);
        entity.atualizar(curso);
        return mapper.toDomain(entity);
    }
}
