package com.GerenciadorDePessoas.GenrenciadorApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "pessoa")
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nome;

    @Column
    private int dataDeNascimento;

    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
