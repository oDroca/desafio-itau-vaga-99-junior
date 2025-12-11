package dev.droca.desafio_itau.db;

import java.util.HashMap;
import java.util.Map;

import dev.droca.desafio_itau.dto.TransactionRequestDTO;


public class Db {
    Map<Integer, TransactionRequestDTO> database = new HashMap<Integer, TransactionRequestDTO>();

    int id = 0;

    public void save(TransactionRequestDTO transactionRequest) {
        database.put(id++, transactionRequest);
        id = id++;
    }

}