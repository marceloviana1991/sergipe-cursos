package marceloviana1991.sergipe_cursos.infra.gateways;


import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoRepository;

import java.util.List;

public class RepositorioCursoJpa implements RepositorioCurso {

    private final CursoRepository repositorio;

    public RepositorioCursoJpa(CursoRepository repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public CursoResponseDto cadastrarCurso(CursoRequestDto requestDto) {
        Curso curso = new Curso(requestDto.nome(), requestDto.descricao(), requestDto.vagas());
        CursoEntity entity = new CursoEntity(curso);
        repositorio.save(entity);
        return new CursoResponseDto(
                entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas()
        );
    }

    @Override
    public List<CursoResponseDto> listarCursos() {
        List<CursoEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(entity -> new CursoResponseDto(
                                entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas()))
                .toList();
    }

    @Override
    public CursoResponseDto detalharCurso(Long id) {
        CursoEntity entity = repositorio.getReferenceById(id);
        return new CursoResponseDto(
                entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas()
        );
    }

    @Override
    public void excluirCurso(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public CursoResponseDto atualizarCurso(Long id, CursoRequestDto requestDto) {
        Curso curso = new Curso(requestDto.nome(), requestDto.descricao(), requestDto.vagas());
        CursoEntity entity = repositorio.getReferenceById(id);
        entity.atualizar(curso);
        return new CursoResponseDto(
                entity.getId(), entity.getNome(), entity.getDescricao(), entity.getVagas()
        );
    }
}
