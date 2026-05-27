package com.devari.spring_boot_essentials.service;

import com.devari.spring_boot_essentials.database.model.ExerciciosEntity;
import com.devari.spring_boot_essentials.database.repository.IExerciciosRepository;
import com.devari.spring_boot_essentials.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExerciciosRepository iExerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return iExerciciosRepository.findAll();
    }

    public void save(ExercicioDto exercicioDto){
        iExerciciosRepository.save(ExerciciosEntity.builder()
                        .name(exercicioDto.getName())
                        .grupoMuscular(exercicioDto.getGrupoMuscular())
                .build());
    }

    public List<ExerciciosEntity> getExercicioByGrupoMuscular(String grupoMusucular){
        return iExerciciosRepository.findAllByGrupoMusucular(grupoMusucular);
    }

}
