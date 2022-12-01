package br.com.gabriel.aluno;

import br.com.gabriel.dao.AlunoDAO;
import br.com.gabriel.model.Aluno;

import java.util.Optional;

public class AtualizarAluno {
    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        Optional<Aluno> alunoOptional = alunoDAO.findById(2L);
        Aluno aluno = alunoOptional.get();

        System.out.println(aluno.getId());
        System.out.println(aluno.getNome());
        System.out.println(aluno.getMatricula());

        aluno.setNome("Gabriel Gomes Reis");
        aluno.setMatricula(2021911);

        alunoDAO.update(aluno);
    }
}
