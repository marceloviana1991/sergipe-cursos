package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.aplication.UseCasesCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final UseCasesCurso useCasesCurso;

    public CursoController(UseCasesCurso useCasesCurso) {
        this.useCasesCurso = useCasesCurso;
    }

    @PostMapping
    @Transactional
    public Curso cadastrar(@RequestBody CursoDto curso) {
        return useCasesCurso.cadastrar(curso.nome(), curso.vagas());
    }

    @GetMapping
    public List<Curso> listar() {
        return useCasesCurso.listar();
    }

    @PutMapping
    @Transactional
    public void atualizarDados(@RequestBody CursoDto curso) {
        useCasesCurso.atualizarDados(curso.turma(), curso.nome(), curso.vagas());
    }

    @PutMapping("/desativar/{turma}")
    @Transactional
    public void desativar(@PathVariable String turma) {
        useCasesCurso.desativar(turma);
    }


}
