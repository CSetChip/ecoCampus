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
@Entity(name = "endereco")
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

    private static final long serealVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column
    private String logradouro;

    @NonNull
    @Column
    private int CEP;

    @Column
    private int numero;

    @NonNull
    @Column
    private String cidade;

}
