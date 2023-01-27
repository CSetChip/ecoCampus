package com.GerenciadorDePessoas.GenrenciadorApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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

    @NonNull
    @Column
    private int CEP;

    @NonNull
    @Column
    private int numero;

    @NotBlank
    @Column
    private String cidade;

}
