package marceloviana1991.sergipe_cursos.infra.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaRequestDto;
import marceloviana1991.sergipe_cursos.application.dto.matricula.MatriculaResponseDto;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.CadastroMatricula;
import marceloviana1991.sergipe_cursos.application.usecases.matricula.ListagemMatricula;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final CadastroMatricula cadastroMatricula;
    private final ListagemMatricula listagemMatricula;

    public MatriculaController(CadastroMatricula cadastroMatricula, ListagemMatricula listagemMatricula) {
        this.cadastroMatricula = cadastroMatricula;
        this.listagemMatricula = listagemMatricula;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarMatricula(@RequestBody MatriculaRequestDto requestDto) {
        try {
            return ResponseEntity.ok(cadastroMatricula.cadastrarMatricula(requestDto));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(new MensagemDeErro(exception.getMessage()));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<MatriculaResponseDto> listarMatriculas() {
        return listagemMatricula.listarMatriculas();
    }


}
