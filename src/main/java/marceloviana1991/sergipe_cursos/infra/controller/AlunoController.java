package marceloviana1991.sergipe_cursos.infra.controller;

import marceloviana1991.sergipe_cursos.application.usecases.CadastroAluno;
import marceloviana1991.sergipe_cursos.application.usecases.DetalhamentoAluno;
import marceloviana1991.sergipe_cursos.application.usecases.ListagemAluno;
import marceloviana1991.sergipe_cursos.domain.entities.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final CadastroAluno cadastroAluno;
    private final ListagemAluno listagemAluno;
    private final DetalhamentoAluno detalhamentoAluno;

    public AlunoController(CadastroAluno cadastroAluno, ListagemAluno listagemAluno, DetalhamentoAluno detalhamentoAluno) {
        this.cadastroAluno = cadastroAluno;
        this.listagemAluno = listagemAluno;
        this.detalhamentoAluno = detalhamentoAluno;
    }

    @PostMapping
    public AlunoDto cadastrarAluno(@RequestBody AlunoDto alunoDto) {
        Aluno aluno = cadastroAluno.cadastrarAluno(new Aluno(alunoDto.cpf(),
                alunoDto.nome(), alunoDto.nascimento(), alunoDto.email()));
        return new AlunoDto(aluno.getCpf(), aluno.getNome(), aluno.getNascimento(), aluno.getEmail());
    }

    @GetMapping
    public List<AlunoDto> listarAlunos() {
        List<Aluno> alunoList = listagemAluno.listarAlunos();
        return alunoList
                .stream()
                .map(aluno -> new AlunoDto(aluno.getCpf(), aluno.getNome(), aluno.getNascimento(), aluno.getEmail()))
                .toList();
    }

    @GetMapping("{id}")
    public AlunoDto detatlharAluno(@PathVariable Long id) {
        Aluno aluno = detalhamentoAluno.detalharAluno(id);
        return new AlunoDto(aluno.getCpf(), aluno.getNome(), aluno.getNascimento(), aluno.getEmail());
    }
}
