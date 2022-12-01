package br.com.gabriel.aluno;

import br.com.gabriel.dao.AlunoDAO;
import br.com.gabriel.model.Aluno;

import java.util.List;
import java.util.Optional;

public class ListarAlunos {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        // Listando todos os alunos
//        List<Aluno> alunos = alunoDAO.findAll();
//
//        for (Aluno aluno: alunos
//             ) {
//            System.out.println("ID: " + aluno.getId());
//            System.out.println("Nome: " + aluno.getNome());
//            System.out.println("Matrícula: " + aluno.getMatricula());
//
//            System.out.println("=========================================");
//        }

        Optional<Aluno> alunoOptional = alunoDAO.findById(4L);
        alunoOptional.ifPresent(aluno -> {
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
        });
    }
}
