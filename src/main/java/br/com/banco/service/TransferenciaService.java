package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;
 
    public Transferencia create(Transferencia transferencia){
        return transferenciaRepository.save(transferencia);
    }

    Transferencia get(int id){
        return null;
    }

    public List<Transferencia> findAll(){
        return transferenciaRepository.findAll();
    }

    void delete(Transferencia transferencia){  };

}
