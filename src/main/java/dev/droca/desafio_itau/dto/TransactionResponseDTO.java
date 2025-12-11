package dev.droca.desafio_itau.dto;

import java.time.OffsetDateTime;

public record TransactionResponseDTO(
    Double valor,
    OffsetDateTime dataHora
) {}
