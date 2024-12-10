package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;
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
        List<String> listaDeAlunosMatriculados = capturaListaDeAlunosMatriculados(alunoEntity);
        Matricula matricula = new Matricula(alunoEntity.getId(), cursoEntity.getId(), listaDeAlunosMatriculados ,
                cursoEntity.getVagas());
        MatriculaEntity matriculaEntity = new MatriculaEntity(
                matricula.getIdAluno(), matricula.getIdCurso(), cursoEntity);
        repositorio.save(matriculaEntity);
        return new MatriculaResponseDto(
                matriculaEntity.getMatriculaKey().getAlunoId(), matriculaEntity.getMatriculaKey().getCursoId());
    }

    @Override
    public List<MatriculaResponseDto> listarMatriculas() {
        List<MatriculaEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(entity -> new MatriculaResponseDto(
                         entity.getMatriculaKey().getAlunoId(), entity.getMatriculaKey().getCursoId())
                )
                .toList();
    }

    private List<String> capturaListaDeAlunosMatriculados(AlunoEntity alunoEntity) {
        List<MatriculaEntity> matriculaEntityList = repositorio.findAllByMatriculaKeyAlunoId(alunoEntity.getId());
        return matriculaEntityList.stream().map(entity -> entity.getMatriculaKey().getAlunoId()).toList();
    }
}
