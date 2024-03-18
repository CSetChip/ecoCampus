package br.edu.ifpb.dac.ecoCampus.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_bicycle")
public class Bicycle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(length = 50)
    private String brand;

    @Column(length = 50)
    private String model;

    @Column(length = 20)
    private String color;

    @Column
    private Integer year;

    @Column(name = "available", nullable = false)
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "point_access_id")
    private AccessPoint point_access_id;

    public Bicycle() {
        this.available = true;
    }

}
