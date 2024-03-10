package com.farol.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "bicicleta")
public class Bicicleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(length = 50)
    private String marca;

    @Column(length = 50)
    private String modelo;

    @Column(length = 20)
    private String Cor;

    @Column
    private Integer ano;

    @Column(name = "diponivel", nullable = false)
    private boolean diponivel;

    @ManyToOne
    @JoinColumn(name = "ponto_acesso_id")
    private PontoAcesso pontoAcesso;

    public Bicicleta() {
        this.diponivel = true;
    }

}
