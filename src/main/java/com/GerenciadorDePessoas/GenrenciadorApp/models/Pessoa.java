package com.GerenciadorDePessoas.GenrenciadorApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
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

    @NonNull
    @Column
    private String nome;

    @NonNull
    @Column
    private int dataDeNascimento;

    @NonNull
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoPrincipal;

}
