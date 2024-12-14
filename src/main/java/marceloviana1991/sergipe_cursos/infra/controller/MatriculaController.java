package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.aplication.UseCasesMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final UseCasesMatricula useCasesMatricula;

    public MatriculaController(UseCasesMatricula useCasesMatricula) {
        this.useCasesMatricula = useCasesMatricula;
    }


    @PostMapping
    @Transactional
    public Matricula cadastrar(@RequestBody MatriculaDto matriculaDto) {
        return useCasesMatricula.cadastrar(matriculaDto.cpfAluno(), matriculaDto.turmaCurso());
    }

    @GetMapping
    public List<Matricula> listar() {
        return useCasesMatricula.listar();
    }
}
