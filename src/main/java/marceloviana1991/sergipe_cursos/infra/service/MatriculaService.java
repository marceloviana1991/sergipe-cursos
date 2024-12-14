package marceloviana1991.sergipe_cursos.infra.service;

import marceloviana1991.sergipe_cursos.aplication.GatewayMatricula;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import marceloviana1991.sergipe_cursos.domain.MatriculaBuilder;
import marceloviana1991.sergipe_cursos.infra.orm.*;

import java.util.List;

public class MatriculaService implements GatewayMatricula {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Matricula cadastrar(String cpfAluno, String turmaCurso) {
        CursoEntity cursoEntity = cursoRepository.getReferenceById(turmaCurso);
        AlunoEntity alunoEntity = alunoRepository.getReferenceById(cpfAluno);
        MatriculaBuilder matriculaBuilder = new MatriculaBuilder(
                matriculaRepository.listaDeCpsDeAlunosMatriculados(turmaCurso),
                alunoRepository.findAllCpfs(),
                cursoRepository.findAllTurmaByAtivoTrue());
        matriculaBuilder.verificaSeAlunoJaPossuiMatriculaNoCurso(cpfAluno);
        matriculaBuilder.verificaSeCursoPossuiVagasDisponiveis(cursoEntity.getVagas());
        MatriculaEntity matriculaEntity = new MatriculaEntity(alunoEntity, cursoEntity);
        matriculaRepository.save(matriculaEntity);
        return matriculaBuilder.createMatricula(cpfAluno, turmaCurso);
    }

    @Override
    public List<Matricula> listar() {
        return matriculaRepository.findAll()
                .stream()
                .map(matriculaEntity -> new Matricula(
                        matriculaEntity.getAlunoEntity().getCpf(), matriculaEntity.getCursoEntity().getTurma()))
                .toList();
    }
}
