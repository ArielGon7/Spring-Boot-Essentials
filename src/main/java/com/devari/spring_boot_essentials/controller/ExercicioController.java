package com.devari.spring_boot_essentials.controller;

import com.devari.spring_boot_essentials.database.model.ExerciciosEntity;
import com.devari.spring_boot_essentials.dto.ExercicioDto;
import com.devari.spring_boot_essentials.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
@Validated
public class ExercicioController {

    private ExerciciosService exerciciosService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody ExercicioDto exercicioDto){
        exerciciosService.save(exercicioDto);
    }

}
