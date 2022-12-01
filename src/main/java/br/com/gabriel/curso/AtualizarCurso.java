package br.com.gabriel.curso;

import br.com.gabriel.dao.CursoDAO;
import br.com.gabriel.model.Curso;

import java.util.Optional;

public class AtualizarCurso {
    public static void main(String[] args) {

        CursoDAO cursoDAO = new CursoDAO();
        Optional<Curso> cursoOptional = cursoDAO.findById(1L);
        Curso curso = cursoOptional.get();

        System.out.println(curso.getId());
        System.out.println(curso.getNome());

        curso.setNome("ADS");

        cursoDAO.update(curso);

    }
}
