package br.com.banco.controller;

import java.util.List;

import br.com.banco.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.banco.model.Transferencia;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private TransferenciaRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void save(@RequestBody TransferenciaRequestDTO data){
        Transferencia transferencia = new Transferencia();
        repository.save(transferencia);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/transferencias")
    public List<TransferenciaResponseDTO> getAllTransfers(){
        List<TransferenciaResponseDTO> transferenciaList = repository.findAll().stream()
                .map(TransferenciaResponseDTO::new).toList();
        return transferenciaList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/transferencias/{nome}")
    public List<TransferenciaResponseDTO> getAllTransfersById(@PathVariable String nome){
        List<TransferenciaResponseDTO> transferencias = repository
                .findTransfersByNomeOp(nome).stream()
                .map(TransferenciaResponseDTO::new).toList();
        return transferencias;
    }

}
