package com.farol.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "estudante")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(unique = true, nullable = false)
    private int matricula;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 25)
    private String instituicao;

    @Column
    private String email;

    @Column
    private int numero;

    public Estudante() {}
}
