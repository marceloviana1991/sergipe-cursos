package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.usecases.aluno.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final CadastroAluno cadastroAluno;
    private final ListagemAluno listagemAluno;
    private final DetalhamentoAluno detalhamentoAluno;
    private final ExclusaoAluno exclusaoAluno;
    private final AtualizacaoAluno atualizacaoAluno;

    public AlunoController(CadastroAluno cadastroAluno,
                           ListagemAluno listagemAluno,
                           DetalhamentoAluno detalhamentoAluno,
                           ExclusaoAluno exclusaoAluno, AtualizacaoAluno atualizacaoAluno) {
        this.cadastroAluno = cadastroAluno;
        this.listagemAluno = listagemAluno;
        this.detalhamentoAluno = detalhamentoAluno;
        this.exclusaoAluno = exclusaoAluno;
        this.atualizacaoAluno = atualizacaoAluno;
    }

    @PostMapping
    @Transactional
    public AlunoResponseDto cadastrarAluno(@RequestBody AlunoRequestDto requestDto) {
        return cadastroAluno.cadastrarAluno(requestDto);
    }

    @GetMapping
    public List<AlunoResponseDto> listarAlunos() {
        return listagemAluno.listarAlunos();
    }

    @GetMapping("{id}")
    public AlunoResponseDto detatlharAluno(@PathVariable Long id) {
        return detalhamentoAluno.detalharAluno(id);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluirAluno(@PathVariable Long id) {
        exclusaoAluno.excluirAluno(id);
    }

    @PutMapping("{id}")
    @Transactional
    public AlunoResponseDto atualizarAluno(@PathVariable Long id, @RequestBody AlunoRequestDto requestDto) {
        return atualizacaoAluno.atualizarAluno(id, requestDto);
    }
}
