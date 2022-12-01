package br.com.gabriel.dao;

import br.com.gabriel.infra.ConnectionFactory;
import br.com.gabriel.model.Aluno;
import br.com.gabriel.model.AlunoCurso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoCursoDAO implements IAlunoCurso {

    @Override
    public AlunoCurso save(AlunoCurso alunoCurso) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO aluno_curso (aluno_id, curso_id) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, alunoCurso.getAluno_id());
            preparedStatement.setLong(2, alunoCurso.getCurso_id());

            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return alunoCurso;
    }

    @Override
    public List<AlunoCurso> findAll() {
        return null;
    }
}
