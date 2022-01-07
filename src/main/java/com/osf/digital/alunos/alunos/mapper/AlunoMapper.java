package com.osf.digital.alunos.alunos.mapper;

import com.osf.digital.alunos.alunos.controller.dto.AlunoDTO;
import com.osf.digital.alunos.alunos.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper . class);

    AlunoDTO alunoToAlunoDTO (Aluno aluno);

    List<AlunoDTO> map(List<Aluno> alunos);
}
