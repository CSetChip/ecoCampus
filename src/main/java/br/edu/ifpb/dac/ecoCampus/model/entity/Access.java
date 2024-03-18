package br.edu.ifpb.dac.ecoCampus.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_access")
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @OneToOne
    @JoinColumn(name = "bicycle_id")
    private Bicycle bicycle_id;

    @Column(name = "start_time")
    private LocalDateTime start_time;

    @Column(name = "hora_fim")
    private LocalDateTime end_time;

    @ManyToOne
    @JoinColumn(name = "starting_point_id")
    private AccessPoint starting_point;

    @ManyToOne
    @JoinColumn(name = "arrival_point_id")
    private AccessPoint arrival_point;

    public Access() {
    }
}
