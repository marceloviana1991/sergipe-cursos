package marceloviana1991.sergipe_cursos.infra.gateways.memoria;

import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCursoMemoria implements RepositorioCurso {

    List<Curso> cursoList = new ArrayList<>();

    @Override
    public CursoResponseDto cadastrarCurso(CursoRequestDto requestDto) {
        Curso curso = new Curso(requestDto.nome(), requestDto.descricao(), requestDto.vagas());
        cursoList.add(curso);
        return new CursoResponseDto(
                (long) cursoList.indexOf(curso),
                curso.getNome(),
                curso.getDescricao(),
                curso.getVagas());
    }

    @Override
    public List<CursoResponseDto> listarCursos() {
        return cursoList
                .stream()
                .map(c -> new CursoResponseDto(
                        (long) cursoList.indexOf(c),
                        c.getNome(),
                        c.getDescricao(),
                        c.getVagas()))
                .toList();
    }

    @Override
    public CursoResponseDto detalharCurso(Long id) {
        return listarCursos().get(Math.toIntExact(id));
    }

    @Override
    public void excluirCurso(Long id) {
        listarCursos().remove(Math.toIntExact(id));
    }

    @Override
    public CursoResponseDto atualizarCurso(Long id, CursoRequestDto requestDto) {
        Curso curso = cursoList.get(Math.toIntExact(id));
        curso.setNome(requestDto.nome());
        curso.setDescricao(requestDto.descricao());
        curso.setVagas(requestDto.vagas());
        return new CursoResponseDto(
                (long) cursoList.indexOf(curso),
                curso.getNome(),
                curso.getDescricao(),
                curso.getVagas());
    }

    public void preencheVaga(Long id) {
        Curso curso = cursoList.get(Math.toIntExact(id));
        if (curso.getVagas() <= 0) {
            throw new IllegalArgumentException("Vaga indisponível!");
        }
        curso.setVagas(curso.getVagas()-1);
    }
}
