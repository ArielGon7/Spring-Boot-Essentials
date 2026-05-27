package com.devari.spring_boot_essentials.service;

import com.devari.spring_boot_essentials.database.model.AlunosEntity;
import com.devari.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import com.devari.spring_boot_essentials.database.repository.IAlunosRepository;
import com.devari.spring_boot_essentials.database.repository.IAvaliacoesFisicasRepository;
import com.devari.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import com.devari.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacoesFisicasService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));

        AvaliacoesFisicasEntity avaliacoesFisicasEntity = aluno.getAvaliacoesFisicas();
        if(avaliacoesFisicasEntity != null){
            throw new Exception("Avaliacao fisica ja cadastrada para este usuario");
        }

    }


}
