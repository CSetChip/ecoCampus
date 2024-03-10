package com.farol.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pontoAcesso")
public class PontoAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String instituicao;

    private String endereco;

    @ManyToOne
    @JoinColumn(name = "bicicletas_id")
    private Bicicleta bicicletas = null;

    public PontoAcesso() {}
}
