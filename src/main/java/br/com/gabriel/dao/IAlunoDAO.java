package br.com.gabriel.dao;

import br.com.gabriel.model.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {

    Aluno save(Aluno aluno);
    Aluno update(Aluno aluno);
    void delete(Long id);
    List<Aluno> findAll();
    Optional<Aluno> findById(Long id);
}
