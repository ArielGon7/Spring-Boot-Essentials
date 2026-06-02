package com.devari.spring_boot_essentials.service;

import com.devari.spring_boot_essentials.database.model.AlunosEntity;
import com.devari.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import com.devari.spring_boot_essentials.database.repository.IAlunosRepository;
import com.devari.spring_boot_essentials.database.repository.IAvaliacoesFisicasRepository;
import com.devari.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import com.devari.spring_boot_essentials.exception.BadRequestException;
import com.devari.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacoesFisicasService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));

        AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacoesFisicas();
        if(avaliacaoFisica != null){
            throw new BadRequestException("Avaliacao fisica ja cadastrada para este usuario");
        }

        avaliacaoFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .percentualGorduraCorporal(avaliacaoFisicaDto.getPercentualGordura())
                .build();

        aluno.setAvaliacoesFisicas(avaliacaoFisica);
        alunosRepository.save(aluno);

    }

}
