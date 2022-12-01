package br.com.gabriel.dao;


import br.com.gabriel.model.AlunoCurso;

import java.util.List;

public interface IAlunoCurso {

    AlunoCurso save(AlunoCurso alunoCurso);

    List<AlunoCurso> findAll();
}
