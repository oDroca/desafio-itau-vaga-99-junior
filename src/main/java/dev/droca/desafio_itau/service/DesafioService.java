package dev.droca.desafio_itau.service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import dev.droca.desafio_itau.db.Db;
import dev.droca.desafio_itau.dto.StatisticResponseDTO;
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

    public void deleteTransaction() {
        db.delete();
    }
    
    public StatisticResponseDTO getStatistic() {
        OffsetDateTime limitDate = OffsetDateTime.now().minusSeconds(60);
        Collection<TransactionRequestDTO> dbValues = db.getDatabase();

        Set<TransactionRequestDTO> betweenValues = new HashSet<>();

        Integer count = betweenValues.size();

        if (count == 0) {
            return new StatisticResponseDTO(0, 0.0, 0.0, 0.0, 0.0);
        }

        Double sum = 0.0;
        Double avg = null;
        Double min = null;
        Double max = null;

        for (TransactionRequestDTO value : dbValues) {
            Boolean verifyTime = value.dataHora().toEpochSecond() >= limitDate.toEpochSecond();
            if (verifyTime) betweenValues.add(value);
        }


        for (TransactionRequestDTO value : betweenValues) {
            sum = sum + value.valor();

            if (min == null) min = value.valor();
            if (max == null) max = value.valor();

            if (value.valor() < min) min = value.valor();
            if (value.valor() > max) max = value.valor();
        }

        for (TransactionRequestDTO value : betweenValues) {
            sum = sum + value.valor();

            if (avg == null) avg = value.valor();

            avg = sum / betweenValues.size();
        }
        
        return new StatisticResponseDTO(count, (Math.round(sum*100) / 100.0), (Math.round(avg*100) / 100.0), (Math.round(min*100) / 100.0), (Math.round(max*100) / 100.0));
    }

}
