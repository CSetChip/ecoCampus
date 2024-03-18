package br.edu.ifpb.dac.ecoCampus.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessPointDTO {
    private Long id;
    private String institution;
    private String address;
    private List<BicycleDTO> bicycleDTOS;
}
