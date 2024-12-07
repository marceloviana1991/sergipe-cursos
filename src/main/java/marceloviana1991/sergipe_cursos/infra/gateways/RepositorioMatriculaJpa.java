package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.infra.persistence.*;

import java.util.List;

public class RepositorioMatriculaJpa implements RepositorioMatricula {

    private final MatriculaRepository repositorio;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public RepositorioMatriculaJpa(MatriculaRepository repositorio, AlunoRepository alunoRepository,
                                   CursoRepository cursoRepository) {
        this.repositorio = repositorio;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public MatriculaResponseDto cadastrarMatricula(MatriculaRequestDto requestDto) {
        AlunoEntity alunoEntity = alunoRepository.getReferenceById(requestDto.alunoId());
        CursoEntity cursoEntity = cursoRepository.getReferenceById(requestDto.cursoId());
        MatriculaEntity matriculaEntity = new MatriculaEntity(alunoEntity, cursoEntity);
        repositorio.save(matriculaEntity);
        return new MatriculaResponseDto(
                matriculaEntity.getId(), matriculaEntity.getAluno().getId(), matriculaEntity.getCurso().getId());
    }

    @Override
    public List<MatriculaResponseDto> listarMatriculas() {
        List<MatriculaEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(entity -> new MatriculaResponseDto(
                        entity.getId(), entity.getAluno().getId(), entity.getCurso().getId()
                ))
                .toList();
    }
}
