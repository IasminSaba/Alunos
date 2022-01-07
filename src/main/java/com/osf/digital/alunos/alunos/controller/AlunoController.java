package com.osf.digital.alunos.alunos.controller;

import com.osf.digital.alunos.alunos.controller.dto.AlunoDTO;
import com.osf.digital.alunos.alunos.controller.form.AlunoForm;
import com.osf.digital.alunos.alunos.mapper.AlunoMapper;
import com.osf.digital.alunos.alunos.model.Aluno;
import com.osf.digital.alunos.alunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAll(){
        List<Aluno> alunos = alunoService.getAll();

        return new ResponseEntity<List<AlunoDTO>>(AlunoMapper.INSTANCE.map(alunos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getById(@PathVariable Long id){
        Optional<Aluno> optional = alunoService.findById(id);
        if (optional.isPresent()) {
            Aluno aluno = alunoService.getById(id);

            AlunoDTO alunoDTO = AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno);
            return ResponseEntity.ok(alunoDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDTO> create(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
        Aluno aluno = alunoService.create(form.getNome(), form.getIdade(), form.getSerie());

        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        AlunoDTO alunoDTO = AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno);
        return ResponseEntity.created(uri).body(alunoDTO);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @RequestBody AlunoForm form) {
        Optional<Aluno> optional = alunoService.findById(id);
        if (optional.isPresent()) {
            Aluno aluno = alunoService.update(id, form.getNome(), form.getIdade(), form.getSerie());

            AlunoDTO alunoDTO = AlunoMapper.INSTANCE.alunoToAlunoDTO(aluno);
            return ResponseEntity.ok(alunoDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Aluno> optional = alunoService.findById(id);
        if (optional.isPresent()) {
            alunoService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
