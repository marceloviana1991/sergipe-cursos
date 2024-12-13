package marceloviana1991.sergipe_cursos.infra.service;

import marceloviana1991.sergipe_cursos.aplication.GatewayAluno;
import marceloviana1991.sergipe_cursos.domain.Aluno;
import marceloviana1991.sergipe_cursos.domain.AlunoBuilder;
import marceloviana1991.sergipe_cursos.infra.orm.AlunoEntity;
import marceloviana1991.sergipe_cursos.infra.orm.AlunoRepository;

import java.util.List;

public class AlunoService implements GatewayAluno {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno cadastrar(String cpf, String nome, String email) {
        AlunoBuilder alunoBuilder = new AlunoBuilder(alunoRepository.findAllCpfs(), alunoRepository.findAllEmails());
        AlunoEntity alunoEntity = new AlunoEntity(cpf, nome, email);
        alunoRepository.save(alunoEntity);
        return alunoBuilder.createAluno(cpf, nome, email);
    }

    @Override
    public List<Aluno> listar() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoEntity -> new Aluno(
                        alunoEntity.getCpf(), alunoEntity.getNome(), alunoEntity.getEmail()))
                .toList();
    }

    @Override
    public void atualizarDados(String cpf, String nome, String email) {
        AlunoBuilder alunoBuilder = new AlunoBuilder(alunoRepository.findAllCpfs(), alunoRepository.findAllEmails());
        alunoBuilder.verificaSeJaPossuiEmailCadastrado(email);
        AlunoEntity alunoEntity = alunoRepository.getReferenceById(cpf);
        if (nome != null) {alunoEntity.setNome(nome);}
        if (email != null) {alunoEntity.setEmail(email);}
    }
}
