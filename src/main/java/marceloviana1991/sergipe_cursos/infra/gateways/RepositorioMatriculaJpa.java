package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import marceloviana1991.sergipe_cursos.infra.persistence.*;

import java.util.List;

public class RepositorioMatriculaJpa implements RepositorioMatricula {

    private final MatriculaRepository repositorio;
    private final MatriculaEntityMapper mapper;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public RepositorioMatriculaJpa(MatriculaRepository repositorio,
                                   MatriculaEntityMapper mapper, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.repositorio = repositorio;
        this.mapper = mapper;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Matricula cadastrarMatricula(Long alunoId, Long cursoId) {
        AlunoEntity alunoEntity = alunoRepository.getReferenceById(alunoId);
        CursoEntity cursoEntity = cursoRepository.getReferenceById(cursoId);
        MatriculaEntity matriculaEntity = new MatriculaEntity(alunoEntity, cursoEntity);
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
