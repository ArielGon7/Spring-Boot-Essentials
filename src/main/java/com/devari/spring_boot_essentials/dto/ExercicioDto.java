package com.devari.spring_boot_essentials.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExercicioDto {

    @NotBlank // N PODE SER NULL E NEM EMPTY
    private String name;
    @NotBlank
    private String grupoMuscular;

}
