package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

    Transferencia save(Transferencia transferencia);
    
    List<Transferencia> findAll();

    @Query(value = "select * from transferencia where conta_id = ?1", nativeQuery = true)
    List<Transferencia> findTransfersById(@Param("id") int id);

    @Query(value = "select * from transferencia where nome_operador_transacao = ?1", nativeQuery = true)
    List<Transferencia> findTransfersByNomeOp(@Param("nome") String nome);

    void delete(Transferencia transferencia);

}
