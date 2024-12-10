package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.curso.CursoResponseDto;
import marceloviana1991.sergipe_cursos.application.usecases.curso.*;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> cadastrarCurso(@RequestBody CursoRequestDto requestDto) {
        try {
            return ResponseEntity.ok(
                    cadastroCurso.cadastrarCurso(requestDto.nome(), requestDto.descricao(), requestDto.vagas()));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(new MensagemDeErro(exception.getMessage()));
        }
    }

    @GetMapping
    public List<CursoResponseDto> listarCursos() {
        return listagemCurso.listarCursos();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> detalharCurso(@PathVariable String id) {
        try {
            return ResponseEntity.ok(detalhamentoCurso.detalharCurso(id));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> excluiCurso(@PathVariable String id) {
        try {
            exclusaoCurso.excluirCurso(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> atualizarCurso(@PathVariable String id, @RequestBody CursoRequestDto requestDto) {
        try {
            return ResponseEntity.ok(
                    atualizacaoCurso.atualizarCurso(id, requestDto.nome(), requestDto.descricao(), requestDto.vagas()));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(new MensagemDeErro(exception.getMessage()));
        }
    }
}
