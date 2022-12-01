package br.com.gabriel.model;

public class Aluno {
    private Long id;
    private String nome;
    private int matricula;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(Long id, String nome, int matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
