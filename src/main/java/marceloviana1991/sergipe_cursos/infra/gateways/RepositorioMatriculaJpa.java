package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import marceloviana1991.sergipe_cursos.infra.persistence.*;

import java.util.List;

public class RepositorioMatriculaJpa implements RepositorioMatricula {

    private final MatriculaRepository repositorio;
    private final MatriculaEntityMapper mapper;

    public RepositorioMatriculaJpa(MatriculaRepository repositorio,
                                   MatriculaEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Matricula cadastrarMatricula(Matricula matricula) {
        MatriculaEntity matriculaEntity = mapper.toEntity(matricula);
        repositorio.save(matriculaEntity);
        return mapper.toDomain(matriculaEntity);
    }

    @Override
    public List<Matricula> listarMatriculas() {
        List<MatriculaEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
