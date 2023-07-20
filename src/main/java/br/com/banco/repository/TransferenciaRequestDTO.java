package br.com.banco.repository;

import br.com.banco.model.Conta;

import java.math.BigDecimal;
import java.time.Instant;

public record TransferenciaRequestDTO (Instant data_transferencia, BigDecimal valor, String tipo,
                                       String nome_operador_transacao, Conta conta) {

}
