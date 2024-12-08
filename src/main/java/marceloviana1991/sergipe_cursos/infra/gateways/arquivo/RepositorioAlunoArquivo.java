package marceloviana1991.sergipe_cursos.infra.gateways.arquivo;

import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.gateways.RepositorioAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RepositorioAlunoArquivo implements RepositorioAluno {

    List<AlunoResponseDto> list = new LinkedList<>();

    @Override
    public AlunoResponseDto cadastrarAluno(AlunoRequestDto requestDto) {
        Aluno aluno = new Aluno(requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email());
        AlunoResponseDto alunoResponseDto = new AlunoResponseDto(
                (long) list.size(), aluno.getCpf(), aluno.getNome(), aluno.getNascimento(), aluno.getEmail());
        list.add(alunoResponseDto);
        return alunoResponseDto;
    }

    @Override
    public List<AlunoResponseDto> listarAlunos() {
        return list;
    }

    @Override
    public AlunoResponseDto detalharAluno(Long id) {
        for (AlunoResponseDto responseDto: list) {
            if (Objects.equals(responseDto.id(), id)) {
                return responseDto;
            }
        }
        return null;
    }

    @Override
    public void excluirAluno(Long id) {
        list.removeIf(responseDto -> Objects.equals(responseDto.id(), id));
    }

    @Override
    public AlunoResponseDto atualizarAluno(Long id, AlunoRequestDto requestDto) {
        list.removeIf(responseDto -> Objects.equals(responseDto.id(), id));
        AlunoResponseDto alunoResponseDto = new AlunoResponseDto(
                id, requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email());
        list.add(alunoResponseDto);
        return null;
    }

    public void gravaEmArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.list.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
