package br.com.gabriel.curso;

import br.com.gabriel.dao.CursoDAO;
import br.com.gabriel.model.Curso;

import java.util.List;
import java.util.Optional;

public class ListarCursos {
    public static void main(String[] args) {
        CursoDAO cursoDAO = new CursoDAO();

        //Listar todos os cursos
//        List<Curso> cursos = cursoDAO.findAll();
//
//        for (Curso curso : cursos
//             ) {
//            System.out.println("ID: " + curso.getId());
//            System.out.println("Nome: " + curso.getNome());
//
//            System.out.println("=========================================");
//        }

        //Buscando por ID
        Optional<Curso> cursoOptional = cursoDAO.findById(1L);
        cursoOptional.ifPresent(curso -> {
            System.out.println("ID: " + curso.getId());
            System.out.println("Nome: " + curso.getNome());
        });
    }
}
