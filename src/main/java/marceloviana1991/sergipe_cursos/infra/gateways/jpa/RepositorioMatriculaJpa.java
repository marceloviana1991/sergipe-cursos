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
        List<String> listaDeAlunosMatriculados = listarAlunosMatriculados(requestDto.cursoId());
        Integer quantidadeDeVagasDisponiveis = verificarQuantidadeDeVagasDisponiveis(requestDto.cursoId());
        Matricula matricula = new Matricula(requestDto.alunoId(), requestDto.cursoId());
        matricula.verificaSeAlunoJaPossuiMatricula(listaDeAlunosMatriculados);
        matricula.verificaSeCursoPossuiVagaDisponivel(quantidadeDeVagasDisponiveis);
        MatriculaEntity matriculaEntity = criarEntidadeJpa(matricula);
        repositorio.save(matriculaEntity);
        return new MatriculaResponseDto(
                matriculaEntity.getAlunoEntity().getId(), matriculaEntity.getCursoEntity().getId());
    }

    @Override
    public List<MatriculaResponseDto> listarMatriculas() {
        List<MatriculaEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(entity -> new MatriculaResponseDto(
                         entity.getAlunoEntity().getId(), entity.getCursoEntity().getId())
                )
                .toList();
    }

    @Override
    public List<String> listarAlunosMatriculados(String cursoId) {
        return repositorio.alunosMatriculadosPorCurso(cursoId);
    }

    @Override
    public Integer verificarQuantidadeDeVagasDisponiveis(String cursoId) {
        return cursoRepository.quantidadeDeVagasNoCurso(cursoId);
    }

    private MatriculaEntity criarEntidadeJpa(Matricula matricula) {
        AlunoEntity alunoEntity = alunoRepository.getReferenceById(matricula.getIdAluno());
        CursoEntity cursoEntity = cursoRepository.getReferenceById(matricula.getIdCurso());
        return new MatriculaEntity(matricula.getUuid().toString(), alunoEntity, cursoEntity);

    }
}
