package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.aplication.UseCasesAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final UseCasesAluno useCasesAluno;

    public AlunoController(UseCasesAluno useCasesAluno) {
        this.useCasesAluno = useCasesAluno;
    }

    @PostMapping
    @Transactional
    public Aluno cadastrar(@RequestBody AlunoDto aluno) {
        return useCasesAluno.cadastrar(aluno.cpf(), aluno.nome(), aluno.email());
    }

    @GetMapping
    public List<Aluno> listar() {
        return useCasesAluno.listar();
    }

    @PutMapping
    @Transactional
    public void atualizarDados(@RequestBody AlunoDto aluno) {
        useCasesAluno.atualizarDados(aluno.cpf(), aluno.nome(), aluno.email());
    }
}
