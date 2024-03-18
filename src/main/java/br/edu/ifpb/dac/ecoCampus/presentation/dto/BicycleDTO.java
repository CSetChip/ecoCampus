package br.edu.ifpb.dac.ecoCampus.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BicycleDTO {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private boolean available;
    private String institution;

}
