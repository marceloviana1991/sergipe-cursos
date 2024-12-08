package marceloviana1991.sergipe_cursos.infra.gateways.jpa;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoRepository;

import java.util.List;

public class RepositorioAlunoJpa implements RepositorioAluno {

    private final AlunoRepository repositorio;

    public RepositorioAlunoJpa(AlunoRepository repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public AlunoResponseDto cadastrarAluno(AlunoRequestDto requestDto) {
        Aluno aluno = new Aluno(requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email());
        AlunoEntity entity = new AlunoEntity(aluno);
        repositorio.save(entity);
        return new AlunoResponseDto(
                entity.getId(), entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }

    @Override
    public List<AlunoResponseDto> listarAlunos() {
        List<AlunoEntity> entityList = repositorio.findAll();
        return entityList
                .stream()
                .map(entity -> new AlunoResponseDto(
                        entity.getId(),
                        entity.getCpf(),
                        entity.getNome(),
                        entity.getNascimento(),
                        entity.getEmail()
                ))
                .toList();
    }

    @Override
    public AlunoResponseDto detalharAluno(Long id) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        return new AlunoResponseDto(
                entity.getId(), entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }

    @Override
    public void excluirAluno(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public AlunoResponseDto atualizarAluno(Long id, AlunoRequestDto requestDto) {
        AlunoEntity entity = repositorio.getReferenceById(id);
        Aluno aluno = new Aluno(requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email());
        entity.atualizar(aluno);
        return new AlunoResponseDto(
                entity.getId(), entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }


}
