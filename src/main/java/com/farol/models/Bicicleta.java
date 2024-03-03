package com.farol.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Bicicleta")
public class Bicicleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String marca;
    private String modelo;
    private String Cor;
    private Integer ano;

    public Bicicleta() {}

    public long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
