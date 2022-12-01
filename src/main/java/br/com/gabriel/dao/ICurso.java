package br.com.gabriel.dao;

import br.com.gabriel.model.Curso;

import java.util.List;
import java.util.Optional;

public interface ICurso {

    Curso save(Curso curso);

    Curso update(Curso curso);

    void delete(Long id);

    List<Curso> findAll();

    Optional<Curso> findById(Long id);
}
