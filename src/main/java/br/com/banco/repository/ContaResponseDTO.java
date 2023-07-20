package br.com.banco.repository;

import br.com.banco.model.Conta;

public record ContaResponseDTO (int id, String nome_responsavel) {

    public ContaResponseDTO(Conta conta){
        this(conta.getId(), conta.getNome_responsavel());
    }

}
