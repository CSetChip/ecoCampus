package com.farol.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "acesso")
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @OneToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta;

    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicico;

    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFim;

    @Column(name = "Ponto_partida")
    private String PontoPartida;

    @Column(name = "ponto_chegada")
    private String instituicaoChegada;

    public Acesso() {}
}
