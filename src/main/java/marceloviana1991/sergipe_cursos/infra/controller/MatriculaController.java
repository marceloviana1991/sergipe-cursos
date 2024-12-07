package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.usecases.aluno.DetalhamentoAluno;
import marceloviana1991.sergipe_cursos.application.usecases.curso.DetalhamentoCurso;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.CadastroMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.ListagemMatricula;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final CadastroMatricula cadastroMatricula;
    private final ListagemMatricula listagemMatricula;
    private final DetalhamentoAluno detalhamentoAluno;
    private final DetalhamentoCurso detalhamentoCurso;


    public MatriculaController(CadastroMatricula cadastroMatricula,
                               ListagemMatricula listagemMatricula, DetalhamentoAluno detalhamentoAluno, DetalhamentoCurso detalhamentoCurso) {
        this.cadastroMatricula = cadastroMatricula;
        this.listagemMatricula = listagemMatricula;
        this.detalhamentoAluno = detalhamentoAluno;
        this.detalhamentoCurso = detalhamentoCurso;
    }

    @PostMapping
    @Transactional
    public MatriculaDto cadastrarMatricula(@RequestBody MatriculaDto matriculaDto) {
        Aluno aluno = detalhamentoAluno.detalharAluno(matriculaDto.alunoId());
        Curso curso = detalhamentoCurso.detalharCurso(matriculaDto.cursoId());
        Matricula matricula = cadastroMatricula.cadastrarMatricula(new Matricula(aluno, curso));
        return new MatriculaDto(matricula.getId(), aluno.getId(), curso.getId());
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
