package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.CadastroMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.ListagemMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final CadastroMatricula cadastroMatricula;
    private final ListagemMatricula listagemMatricula;


    public MatriculaController(CadastroMatricula cadastroMatricula,
                               ListagemMatricula listagemMatricula) {
        this.cadastroMatricula = cadastroMatricula;
        this.listagemMatricula = listagemMatricula;
    }

    @PostMapping
    @Transactional
    public MatriculaDto cadastrarMatricula(@RequestBody MatriculaDto matriculaDto) {
        Matricula matricula = cadastroMatricula.cadastrarMatricula(matriculaDto.alunoId(), matriculaDto.cursoId());
        return new MatriculaDto(matricula.getId(), matricula.getAluno().getId(), matricula.getCurso().getId());
    }

    @GetMapping
    public List<MatriculaDto> listarMatriculas() {
        List<Matricula> matriculaList = listagemMatricula.listarMatriculas();
        return matriculaList
                .stream()
                .map(matricula -> new MatriculaDto(matricula.getId(), matricula.getAluno().getId(), matricula.getCurso().getId()))
                .toList();
    }


}
