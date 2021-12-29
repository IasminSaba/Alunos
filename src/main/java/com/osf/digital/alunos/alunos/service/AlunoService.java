package com.osf.digital.alunos.alunos.service;

import com.osf.digital.alunos.alunos.model.Aluno;
import com.osf.digital.alunos.alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno create(String nome, String idade, String serie) {
        Aluno aluno = new Aluno(nome, idade, serie);
//        Aluno aluno = null;
//        for(int i=1; i<50000;i++){
//            aluno = new Aluno("nome"+i, "17", "1° ano do Ensino médio");
//            alunoRepository.save(aluno);
//        }
//        return aluno;
        return alunoRepository.save(aluno);
    }

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public Aluno update(Long id, String nome,String idade,String serie) {
        Aluno aluno = alunoRepository.getById(id);

        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setSerie(serie);

        return aluno;
    }

    public boolean delete(Long id) {
        alunoRepository.deleteById(id);

        return true;
    }
}
