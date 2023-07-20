package br.com.banco.controller;

import java.util.List;

import br.com.banco.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.banco.model.Conta;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository repository;
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody ContaRequestDTO data){
        Conta conta = new Conta();
        repository.save(conta);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/contas")
    public List<ContaResponseDTO> getAllContas(){
        List<ContaResponseDTO> contasList = repository.findAll().stream().map(ContaResponseDTO::new).toList();
        return contasList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/contas/{id}")
    public Conta getConta(@PathVariable int id){
        Conta conta = repository.findContaById(id);
        return conta;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/transferencias/{id}")
    public List<TransferenciaResponseDTO> getAllTransfersById(@PathVariable int id){
        List<TransferenciaResponseDTO> transferencias = transferenciaRepository
                .findTransfersById(id).stream()
                .map(TransferenciaResponseDTO::new).toList();
        return transferencias;
    }


}