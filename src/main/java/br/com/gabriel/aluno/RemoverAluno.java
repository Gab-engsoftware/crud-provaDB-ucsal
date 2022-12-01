package br.com.gabriel.aluno;

import br.com.gabriel.dao.AlunoDAO;

public class RemoverAluno {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.delete(3L);
    }
}
