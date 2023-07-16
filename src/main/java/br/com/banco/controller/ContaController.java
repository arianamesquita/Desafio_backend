package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.service.ContaService;

@Controller
@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService service;

    @PostMapping
    public Conta create(Conta conta){
        return service.create(conta);
    }

    @GetMapping("/tranferencia/{id}")
    public List<Transferencia> getAllTransferenciasId(@PathVariable int id){
        return service.getAllTransferenciasId(id);
    }
    
}
