package br.com.gabriel.dao;

import br.com.gabriel.infra.ConnectionFactory;
import br.com.gabriel.model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO implements IAlunoDAO {

    @Override
    public Aluno save(Aluno aluno) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO aluno (nome, matricula) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setInt(2, aluno.getMatricula());

            preparedStatement.executeUpdate();


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            Long generatedId = resultSet.getLong("id");
            aluno.setId(generatedId);

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return aluno;
    }

    @Override
    public Aluno update(Aluno aluno) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE aluno SET nome = ?, matricula = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setInt(2, aluno.getMatricula());
            preparedStatement.setLong(3, aluno.getId());

            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return aluno;
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM aluno WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Aluno> findAll() {
        String sql = "SELECT id, nome, matricula FROM aluno";

        List<Aluno> alunos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                int matricula = resultSet.getInt("matricula");

                Aluno aluno = new Aluno(id, nome, matricula);
                alunos.add(aluno);
            }

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }

        return alunos;
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        String sql = "SELECT id, nome, matricula FROM aluno WHERE id = ?";

        Aluno aluno = null;

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Long pKey = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                int matricula = resultSet.getInt("matricula");

                aluno = new Aluno(pKey, nome, matricula);

            }

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(aluno);
    }
}
