package dev.droca.desafio_itau.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dev.droca.desafio_itau.dto.TransactionRequestDTO;


public class Db {
    private Map<Integer, TransactionRequestDTO> database = new HashMap<Integer, TransactionRequestDTO>();

    private int id = 0;

    public void save(TransactionRequestDTO transactionRequest) {
        database.put(id++, transactionRequest);
        System.out.println(database.values());
        id = id++;
    }

    public void delete() {
        database.clear();
    }

    public Collection<TransactionRequestDTO> getDatabase() {
        return database.values();
    }

}