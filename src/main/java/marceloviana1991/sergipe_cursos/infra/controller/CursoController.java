package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.usecases.curso.*;
import marceloviana1991.sergipe_cursos.domain.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CadastroCurso cadastroCurso;
    private final ListagemCurso listagemCurso;
    private final DetalhamentoCurso detalhamentoCurso;
    private final ExclusaoCurso exclusaoCurso;
    private final AtualizacaoCurso atualizacaoCurso;


    public CursoController(CadastroCurso cadastroCurso,
                           ListagemCurso listagemCurso,
                           DetalhamentoCurso detalhamentoCurso,
                           ExclusaoCurso exclusaoCurso,
                           AtualizacaoCurso atualizacaoCurso) {
        this.cadastroCurso = cadastroCurso;
        this.listagemCurso = listagemCurso;
        this.detalhamentoCurso = detalhamentoCurso;
        this.exclusaoCurso = exclusaoCurso;
        this.atualizacaoCurso = atualizacaoCurso;
    }

    @PostMapping
    @Transactional
    public CursoDto cadastrarCurso(@RequestBody CursoDto cursoDto) {
        Curso curso = cadastroCurso.cadastrarCurso(new Curso(
                cursoDto.nome(), cursoDto.descricao(), cursoDto.vagas()
        ));
        return new CursoDto(curso);
    }

    @GetMapping
    public List<CursoDto> listarCursos() {
        List<Curso> cursoList = listagemCurso.listarCursos();
        return cursoList
                .stream()
                .map(CursoDto::new)
                .toList();
    }

    @GetMapping("{id}")
    public CursoDto detalharCurso(@PathVariable Long id) {
        Curso curso = detalhamentoCurso.detalharCurso(id);
        return new CursoDto(curso);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluiCurso(@PathVariable Long id) {
        exclusaoCurso.excluirCurso(id);
    }

    @PutMapping("{id}")
    @Transactional
    public CursoDto atualizarCurso(@PathVariable Long id, @RequestBody CursoDto cursoDto) {
        Curso curso = atualizacaoCurso.atualizarCurso(id, new Curso(
                cursoDto.nome(), cursoDto.descricao(), cursoDto.vagas()
        ));
        return new CursoDto(curso);
    }
}
