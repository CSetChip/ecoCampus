package br.edu.ifpb.dac.ecoCampus.presentation.controller;

import br.edu.ifpb.dac.ecoCampus.business.Servers.*;
import br.edu.ifpb.dac.ecoCampus.model.entity.Access;
import br.edu.ifpb.dac.ecoCampus.presentation.dto.AccessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/access")
public class AccessController {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private AccessService accessService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BicycleService bicycleService;

    @Autowired
    private AccessPointService accessPointService;


    @GetMapping("/list")
    public ResponseEntity<List<AccessDTO>> listAccess() {
        List<AccessDTO> accessDTOList = accessService.listAccess().stream()
                .map(access -> converterService.convertToDTO(access, AccessDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(accessDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessDTO> findAccessPointById(@PathVariable Long id) throws Exception {
        Access access = accessService.findAccessById(id);
        return ResponseEntity.ok().body(converterService.convertToDTO(access, AccessDTO.class));
    }

    @PostMapping("/save")
    public ResponseEntity<AccessDTO> saveAccessPoint(@RequestBody AccessDTO accessDTO) throws Exception {
        Access access = new Access();
        access.setStudent_id(studentService.findStudentById(accessDTO.getStudentId()));
        access.setBicycle_id(bicycleService.findBicycleById(accessDTO.getBicycleId()));
        access.setStarting_point(accessPointService.findAccessPointById(accessDTO.getStartingPointId()));
        access.setStart_time(LocalDateTime.now());

        access = accessService.saveAccess(access);

        return ResponseEntity.ok().body(converterService.convertToDTO(access, AccessDTO.class));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccessDTO> updateAccess(@PathVariable Long id, @RequestBody AccessDTO newAccessDTO) throws Exception {
        Access access = accessService.findAccessById(id);

        if (newAccessDTO.getArrivalPointId() != null) {
            access.setArrival_point(accessPointService.findAccessPointById(newAccessDTO.getArrivalPointId()));
        }
        access.setEnd_time(LocalDateTime.now());

        accessService.updateAccess(id, access);
        return ResponseEntity.ok().body(converterService.convertToDTO(access, AccessDTO.class));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccessPoint(@PathVariable Long id) throws Exception {
        accessService.deleteAccess(id);
        return ResponseEntity.ok("Access deleted successfully.");
    }

}