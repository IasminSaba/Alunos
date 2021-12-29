package com.osf.digital.alunos.alunos.controller.dto;

import com.osf.digital.alunos.alunos.model.Aluno;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String idade;
    private String serie;

    public AlunoDTO(Aluno aluno){
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.idade = aluno.getIdade();
        this.serie = aluno.getSerie();
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public static List<AlunoDTO> toConvert(List<Aluno> alunos){
        return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    }
}
