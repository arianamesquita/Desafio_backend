package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    
    public Conta create (Conta conta){
        return contaRepository.save(conta);
    }

    Conta getById (int id){
        return contaRepository.findById(id);
    }

    List<Conta> getAll(int id){
        return contaRepository.findAll(id);
    }

    void delete(Conta conta){    }

    public List<Transferencia> getAllTransferenciasId(int id){
        Conta conta = contaRepository.findById(id).get();
        return conta.getTransferencias();
    }

    
}
