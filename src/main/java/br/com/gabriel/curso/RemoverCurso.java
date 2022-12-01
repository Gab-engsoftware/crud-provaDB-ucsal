package br.com.gabriel.curso;

import br.com.gabriel.dao.CursoDAO;

public class RemoverCurso {
    public static void main(String[] args) {
        CursoDAO cursoDAO = new CursoDAO();
        cursoDAO.delete(1L);
    }
}
