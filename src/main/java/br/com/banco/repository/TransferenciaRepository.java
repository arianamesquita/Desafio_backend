package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

    Transferencia save(Transferencia transferencia);
    
    List<Transferencia> findAll();

    Transferencia findById(int id);

    void delete(Transferencia transferencia);

}
