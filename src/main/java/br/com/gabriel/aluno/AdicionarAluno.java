package br.com.gabriel.aluno;

import br.com.gabriel.dao.AlunoDAO;
import br.com.gabriel.model.Aluno;

public class AdicionarAluno {
    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno = new Aluno();

        aluno.setNome("João Victor");
        aluno.setMatricula(20021912);

        alunoDAO.save(aluno);
    }
}
