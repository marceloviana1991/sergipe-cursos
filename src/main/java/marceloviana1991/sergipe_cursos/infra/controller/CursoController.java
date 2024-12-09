package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.usecases.curso.*;
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
    public CursoResponseDto cadastrarCurso(@RequestBody CursoRequestDto requestDto) {
        return cadastroCurso.cadastrarCurso(requestDto.nome(), requestDto.descricao(), requestDto.vagas());
    }

    @GetMapping
    public List<CursoResponseDto> listarCursos() {
        return listagemCurso.listarCursos();
    }

    @GetMapping("{id}")
    public CursoResponseDto detalharCurso(@PathVariable String id) {
        return detalhamentoCurso.detalharCurso(id);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluiCurso(@PathVariable String id) {
        exclusaoCurso.excluirCurso(id);
    }

    @PutMapping("{id}")
    @Transactional
    public CursoResponseDto atualizarCurso(@PathVariable String id, @RequestBody CursoRequestDto requestDto) {
        return atualizacaoCurso.atualizarCurso(id, requestDto.nome(), requestDto.descricao(), requestDto.vagas());
    }
}
