package marceloviana1991.sergipe_cursos.infra.service;

import marceloviana1991.sergipe_cursos.aplication.GatewayCurso;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.infra.orm.CursoEntity;
import marceloviana1991.sergipe_cursos.infra.orm.CursoRepository;

import java.util.List;

public class CursoService implements GatewayCurso {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso cadastrar(String nome, int vagas) {
        Curso curso = new Curso(nome, vagas);
        CursoEntity cursoEntity = new CursoEntity(curso.getTurma(), curso.getNome(), curso.getVagas(), curso.isAtivo());
        cursoRepository.save(cursoEntity);
        return curso;
    }

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAllByAtivoTrue()
                .stream()
                .map(cursoEntity -> new Curso(
                        cursoEntity.getTurma(), cursoEntity.getNome(), cursoEntity.getVagas(), cursoEntity.isAtivo()))
                .toList();
    }

    @Override
    public void atualizarDados(String turma, String nome, Integer vagas) {
        CursoEntity cursoEntity = cursoRepository.getReferenceById(turma);
        if (nome != null) {cursoEntity.setNome(nome);}
        if (vagas != null) {cursoEntity.setVagas(vagas);}
    }

    @Override
    public void desativar(String turma) {
        CursoEntity cursoEntity = cursoRepository.getReferenceById(turma);
        cursoEntity.setAtivo(false);
    }
}
