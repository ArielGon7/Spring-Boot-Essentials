package com.devari.spring_boot_essentials.service;

import com.devari.spring_boot_essentials.database.repository.IExerciciosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExerciciosRepository iExerciciosRepository;

}
