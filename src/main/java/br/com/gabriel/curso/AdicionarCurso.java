package br.com.gabriel.curso;

import br.com.gabriel.dao.CursoDAO;
import br.com.gabriel.model.Curso;

public class AdicionarCurso {
    public static void main(String[] args) {

        CursoDAO cursoDAO = new CursoDAO();

        Curso curso = new Curso();

        curso.setNome("Análise e Desenvolvimento de Sistemas");

        cursoDAO.save(curso);
    }
}
