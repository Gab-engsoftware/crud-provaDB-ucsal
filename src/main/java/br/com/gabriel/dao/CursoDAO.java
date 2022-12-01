package br.com.gabriel.dao;

import br.com.gabriel.infra.ConnectionFactory;
import br.com.gabriel.model.Aluno;
import br.com.gabriel.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO implements ICurso{

    @Override
    public Curso save(Curso curso) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO curso (nome) VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, curso.getNome());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            Long generatedId = resultSet.getLong("id");
            curso.setId(generatedId);

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return curso;
    }

    @Override
    public Curso update(Curso curso) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE curso SET nome = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setLong(2, curso.getId());

            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return curso;
    }


    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Curso> findAll() {
        String sql = "SELECT id, nome FROM curso";

        List<Curso> cursos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");

                Curso curso = new Curso(id, nome);
                cursos.add(curso);
            }

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }

        return cursos;
    }

    @Override
    public Optional<Curso> findById(Long id) {
        String sql = "SELECT id, nome FROM curso WHERE id = ?";

        Curso curso = null;

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Long pKey = resultSet.getLong("id");
                String nome = resultSet.getString("nome");

                curso = new Curso(pKey, nome);

            }

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(curso);
    }
}
