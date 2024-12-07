package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.usecases.aluno.*;
import marceloviana1991.sergipe_cursos.domain.Aluno;
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
    public AlunoDto cadastrarAluno(@RequestBody AlunoDto alunoDto) {
        Aluno aluno = cadastroAluno.cadastrarAluno(new Aluno(
                alunoDto.cpf(), alunoDto.nome(), alunoDto.nascimento(), alunoDto.email()));
        return new AlunoDto(aluno);
    }

    @GetMapping
    public List<AlunoDto> listarAlunos() {
        List<Aluno> alunoList = listagemAluno.listarAlunos();
        return alunoList
                .stream()
                .map(AlunoDto::new)
                .toList();
    }

    @GetMapping("{id}")
    public AlunoDto detatlharAluno(@PathVariable Long id) {
        Aluno aluno = detalhamentoAluno.detalharAluno(id);
        return new AlunoDto(aluno);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluirAluno(@PathVariable Long id) {
        exclusaoAluno.excluirAluno(id);
    }

    @PutMapping("{id}")
    @Transactional
    public AlunoDto atualizarAluno(@PathVariable Long id, @RequestBody AlunoDto alunoDto) {
        Aluno aluno = atualizacaoAluno.atualizarAluno(id, new Aluno(
                alunoDto.cpf(), alunoDto.nome(), alunoDto.nascimento(), alunoDto.email()
        ));
        return new AlunoDto(aluno);
    }
}
