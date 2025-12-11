package dev.droca.desafio_itau.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import dev.droca.desafio_itau.db.Db;
import dev.droca.desafio_itau.dto.TransactionRequestDTO;
import dev.droca.desafio_itau.dto.TransactionResponseDTO;

@Service
public class DesafioService {

    Db db = new Db();

    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequest) {
        TransactionRequestDTO a = new TransactionRequestDTO(transactionRequest.valor(), OffsetDateTime.now());

        db.save(a);
        return new TransactionResponseDTO(a.valor(), a.dataHora());
    }
    
}
