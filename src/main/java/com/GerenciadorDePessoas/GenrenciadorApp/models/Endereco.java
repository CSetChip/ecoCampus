package com.GerenciadorDePessoas.GenrenciadorApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "endereco")
@Table(name = "TB_ENDERECO")
@NoArgsConstructor
public class Endereco implements Serializable {

    private static final long serealVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column
    private String logradouro;

    @NotBlank
    @Column
    private String CEP;

    @Column
    private int numero;

    @NotBlank
    @Column
    private String cidade;

}
