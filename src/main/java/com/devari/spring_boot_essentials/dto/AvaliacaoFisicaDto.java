package com.devari.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoFisicaDto {

    @NotNull
    public Integer alunoId;
    @NotNull
    public BigDecimal peso;
    @NotNull
    public BigDecimal altura;
    @NotNull
    public BigDecimal percentualGordura;
}
