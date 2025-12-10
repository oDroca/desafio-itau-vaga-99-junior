package dev.droca.desafio_itau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.droca.desafio_itau.dto.TransactionRequestDTO;
import dev.droca.desafio_itau.service.TransactionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("")
public class TransacaoController {
    
    TransactionService transactionService;

    @PostMapping("/transacao")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequestDTO transactionRequest) {
        String response = transactionService.createTransaction(transactionRequest);
        
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
    
    
}
