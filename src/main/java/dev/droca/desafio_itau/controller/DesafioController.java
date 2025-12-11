package dev.droca.desafio_itau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.droca.desafio_itau.dto.StatisticResponseDTO;
import dev.droca.desafio_itau.dto.TransactionRequestDTO;
import dev.droca.desafio_itau.service.DesafioService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/")
public class DesafioController {
    
    DesafioService desafioService;

    public DesafioController(DesafioService desafioService) {
        this.desafioService = desafioService;
    }

    @PostMapping("transacao")
    public ResponseEntity<Object> createTransaction(@RequestBody @Valid TransactionRequestDTO transactionRequest) {
        desafioService.createTransaction(transactionRequest);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @DeleteMapping("transacao")
    public ResponseEntity<Object> deleteTransaction() {
        desafioService.deleteTransaction();
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping("estatistica")
    public ResponseEntity<StatisticResponseDTO> getStatistic() {
        StatisticResponseDTO response = desafioService.getStatistic();
        return new ResponseEntity<StatisticResponseDTO>(response, HttpStatus.OK);
    }
    
}
