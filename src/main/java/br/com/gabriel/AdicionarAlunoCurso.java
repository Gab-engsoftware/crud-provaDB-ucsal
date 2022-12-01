package br.com.gabriel;

import br.com.gabriel.dao.AlunoCursoDAO;
import br.com.gabriel.model.AlunoCurso;

public class AdicionarAlunoCurso {
    public static void main(String[] args) {
        AlunoCursoDAO alunoCursoDAO = new AlunoCursoDAO();

        AlunoCurso alunoCurso = new AlunoCurso();

        alunoCurso.setAluno_id(4L);
        alunoCurso.setCurso_id(2L);

        alunoCursoDAO.save(alunoCurso);
    }
}
