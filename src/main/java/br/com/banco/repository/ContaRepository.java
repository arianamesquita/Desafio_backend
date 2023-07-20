package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

    List<Conta> findAll();

    Conta findContaById(int id);

    void delete(Conta conta);
    
}
