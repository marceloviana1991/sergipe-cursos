package marceloviana1991.sergipe_cursos.infra.gateways.memoria;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAlunoMemoria implements RepositorioAluno {

    List<Aluno> alunoList = new ArrayList<>();

    @Override
    public AlunoResponseDto cadastrarAluno(AlunoRequestDto requestDto) {
        Aluno aluno = new Aluno(requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email());
        alunoList.add(aluno);
        return new AlunoResponseDto(
                (long) alunoList.indexOf(aluno),
                aluno.getCpf(),
                aluno.getNome(),
                aluno.getNascimento(),
                aluno.getEmail()
        );
    }

    @Override
    public List<AlunoResponseDto> listarAlunos() {
        return alunoList
                .stream()
                .map(c -> new AlunoResponseDto(
                        (long) alunoList.indexOf(c),
                        c.getCpf(),
                        c.getNome(),
                        c.getNascimento(),
                        c.getEmail()))
                .toList();
    }

    @Override
    public AlunoResponseDto detalharAluno(Long id) {
        return listarAlunos().get(Math.toIntExact(id));
    }

    @Override
    public void excluirAluno(Long id) {
        listarAlunos().remove(Math.toIntExact(id));
    }

    @Override
    public AlunoResponseDto atualizarAluno(Long id, AlunoRequestDto requestDto) {
        Aluno aluno = alunoList.get(Math.toIntExact(id));
        aluno.setCpf(requestDto.cpf());
        aluno.setNome(requestDto.nome());
        aluno.setNascimento(requestDto.nascimento());
        aluno.setEmail(requestDto.email());
        return new AlunoResponseDto(
                (long) alunoList.indexOf(aluno),
                aluno.getCpf(),
                aluno.getNome(),
                aluno.getNascimento(),
                aluno.getEmail()
        );
    }
}
