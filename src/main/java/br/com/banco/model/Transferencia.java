package br.com.banco.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.*;

import br.com.banco.repository.TransferenciaRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Instant data_transferencia;
    private BigDecimal valor;
    private String tipo;
    private String nome_operador_transacao;
    @Column (name = "conta_id", insertable = false, updatable = false)
    private int conta_id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "conta_id", nullable = false, updatable = false)
    Conta conta = new Conta();

    public Transferencia(TransferenciaRequestDTO data){
        this.data_transferencia = data.data_transferencia();
        this.valor = data.valor();
        this.tipo = data.tipo();
        this.nome_operador_transacao = data.nome_operador_transacao();
        this.conta_id = data.conta().getId();
    }


    
}
