package br.com.banco.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.banco.repository.ContaRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private int id;
    @Column(name = "nome_responsavel")
    private String nome_responsavel;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transferencia> transferencias = new ArrayList<>();

    public Conta get() {
        return null;
    }

    public Conta (ContaRequestDTO data){
        this.nome_responsavel = data.nome_responsavel();
    }

}
