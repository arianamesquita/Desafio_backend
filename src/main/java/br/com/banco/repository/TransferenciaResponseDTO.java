package br.com.banco.repository;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;

import java.math.BigDecimal;
import java.time.Instant;

public record TransferenciaResponseDTO (Instant data_transferencia, BigDecimal valor, String tipo,
                                        String nome_operador_transacao, int conta_id){

    public TransferenciaResponseDTO(Transferencia transferencia){
        this(transferencia.getData_transferencia(), transferencia.getValor(),
               transferencia.getTipo(), transferencia.getNome_operador_transacao(), transferencia.getConta_id());
    }

}
