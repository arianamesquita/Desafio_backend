package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.model.Conta;

@Repository
@Transactional(readOnly = false)
public interface ContaRepository extends JpaRepository<Conta, Long>{

    List<Conta> findAll(int id);

    Conta findById(int id);

    void delete(Conta conta);
    
}
