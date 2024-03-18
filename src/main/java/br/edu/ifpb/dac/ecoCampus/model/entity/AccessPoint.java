package br.edu.ifpb.dac.ecoCampus.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_pointAccess")
public class AccessPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String institution;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "bicycles_id")
    private Bicycle bicycles = null;

    public AccessPoint() {
    }
}
