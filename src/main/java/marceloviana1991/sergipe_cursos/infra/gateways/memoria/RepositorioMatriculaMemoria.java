package marceloviana1991.sergipe_cursos.infra.gateways.memoria;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioMatricula;

import java.util.ArrayList;
import java.util.List;

public class RepositorioMatriculaMemoria implements RepositorioMatricula {

    private final RepositorioCursoMemoria repositorioCursoMemoria;
    private final RepositorioAlunoMemoria repositorioAlunoMemoria;

    public RepositorioMatriculaMemoria(RepositorioCursoMemoria repositorioCursoMemoria,
                                       RepositorioAlunoMemoria repositorioAlunoMemoria) {
        this.repositorioCursoMemoria = repositorioCursoMemoria;
        this.repositorioAlunoMemoria = repositorioAlunoMemoria;
    }

    List<Matricula> matriculaList = new ArrayList<>();

    @Override
    public MatriculaResponseDto cadastrarMatricula(MatriculaRequestDto requestDto) {
        AlunoResponseDto alunoResponseDto = repositorioAlunoMemoria.detalharAluno(requestDto.alunoId());
        CursoResponseDto cursoResponseDto = repositorioCursoMemoria.detalharCurso(requestDto.cursoId());
        if(alunoResponseDto == null || cursoResponseDto == null) {
            throw new IllegalArgumentException("Id não encontrado!");
        }
        repositorioCursoMemoria.preencheVaga(cursoResponseDto.id());
        Matricula matricula = new Matricula(requestDto.alunoId(), requestDto.cursoId());
        matriculaList.add(matricula);
        return new MatriculaResponseDto(
                (long) matriculaList.indexOf(matricula),
                matricula.alunoId(),
                matricula.cursoId()
        );
    }

    @Override
    public List<MatriculaResponseDto> listarMatriculas() {
        return matriculaList
                .stream()
                .map(m -> new MatriculaResponseDto(
                        (long) matriculaList.indexOf(m),
                        m.alunoId(),
                        m.cursoId()))
                .toList();
    }

    public record Matricula(Long alunoId, Long cursoId) {
    }
}

