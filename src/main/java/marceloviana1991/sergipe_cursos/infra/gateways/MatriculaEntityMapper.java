package marceloviana1991.sergipe_cursos.infra.gateways;

import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.domain.Curso;
import marceloviana1991.sergipe_cursos.domain.Matricula;
import marceloviana1991.sergipe_cursos.infra.persistence.AlunoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.CursoEntity;
import marceloviana1991.sergipe_cursos.infra.persistence.MatriculaEntity;

public class MatriculaEntityMapper {

    private final AlunoEntityMapper alunoEntityMapper;
    private final CursoEntityMapper cursoEntityMapper;

    public MatriculaEntityMapper(AlunoEntityMapper alunoEntityMapper, CursoEntityMapper cursoEntityMapper) {
        this.alunoEntityMapper = alunoEntityMapper;
        this.cursoEntityMapper = cursoEntityMapper;
    }

    public MatriculaEntity toEntity(Matricula matricula) {
        AlunoEntity alunoEntity = alunoEntityMapper.toEntity(matricula.getAluno());
        CursoEntity cursoEntity = cursoEntityMapper.toEntity(matricula.getCurso());
        return new MatriculaEntity(alunoEntity, cursoEntity);
    }

    public Matricula toDomain(MatriculaEntity entity) {
        Aluno aluno = alunoEntityMapper.toDomain(entity.getAluno());
        Curso curso = cursoEntityMapper.toDomain(entity.getCurso());
        return new Matricula(entity.getId(), aluno, curso);
    }
}
