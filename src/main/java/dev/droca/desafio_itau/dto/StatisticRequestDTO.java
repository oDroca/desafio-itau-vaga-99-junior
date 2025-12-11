package dev.droca.desafio_itau.dto;

import jakarta.validation.constraints.PositiveOrZero;

public record StatisticRequestDTO(
    @PositiveOrZero(message = "Valor precisa ser positivo")
    int in
) {}
