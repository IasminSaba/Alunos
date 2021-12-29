package com.osf.digital.alunos.alunos.controller.form;

import com.osf.digital.alunos.alunos.model.Aluno;
import com.osf.digital.alunos.alunos.repository.AlunoRepository;

public class AlunoForm {

    private String nome;
    private String idade;
    private String serie;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Aluno toConvert(AlunoRepository brandRepository) {
        return new Aluno(nome, idade, serie);
    }

    public Aluno update(Long id, AlunoRepository alunoRepository){
        Aluno aluno = alunoRepository.getById(id);

        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setSerie(serie);

        return aluno;
    }
}
