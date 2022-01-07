package com.osf.digital.alunos.alunos.mapper;

import com.osf.digital.alunos.alunos.controller.dto.AlunoDTO;
import com.osf.digital.alunos.alunos.controller.form.AlunoForm;
import com.osf.digital.alunos.alunos.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper . class);

    AlunoDTO alunoToAlunoDTO (Aluno aluno);

    AlunoForm alunoFormToAluno (AlunoForm alunoForm);
}
