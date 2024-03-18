package br.edu.ifpb.dac.ecoCampus.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private int registration;
    private String name;
    private String institution;
    private String email;
    private int number;
}
