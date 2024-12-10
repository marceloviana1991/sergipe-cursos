package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.aluno.AlunoResponseDto;
import marceloviana1991.sergipe_cursos.application.usecases.aluno.*;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> cadastrarAluno(@RequestBody AlunoRequestDto requestDto) {

        try {
            return ResponseEntity.ok(cadastroAluno.cadastrarAluno(
                    requestDto.cpf(), requestDto.nome(), requestDto.nascimento(), requestDto.email()));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(new MensagemDeErro(exception.getMessage()));
        }
    }

    @GetMapping
    public List<AlunoResponseDto> listarAlunos() {
        return listagemAluno.listarAlunos();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> detatlharAluno(@PathVariable String id) {
        try {
            return ResponseEntity.ok(detalhamentoAluno.detalharAluno(id));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> excluirAluno(@PathVariable String id) {
        try {
            exclusaoAluno.excluirAluno(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> atualizarAluno(@PathVariable String id, @RequestBody AlunoRequestDto requestDto) {
        try {
            return ResponseEntity.ok(atualizacaoAluno.atualizarAluno(id, requestDto.nome(), requestDto.nascimento()));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(new MensagemDeErro(exception.getMessage()));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
