package br.edu.ifpb.dac.ecoCampus.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessDTO {
    private Long id;
    private Long studentId;
    private Long bicycleId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long startingPointId;
    private Long arrivalPointId;
}
