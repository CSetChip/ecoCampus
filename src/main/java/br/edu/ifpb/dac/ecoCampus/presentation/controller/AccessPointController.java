package br.edu.ifpb.dac.ecoCampus.presentation.controller;

import br.edu.ifpb.dac.ecoCampus.business.Servers.AccessPointService;
import br.edu.ifpb.dac.ecoCampus.business.Servers.BicycleService;
import br.edu.ifpb.dac.ecoCampus.business.Servers.ConverterService;
import br.edu.ifpb.dac.ecoCampus.model.entity.AccessPoint;
import br.edu.ifpb.dac.ecoCampus.presentation.dto.AccessPointDTO;
import br.edu.ifpb.dac.ecoCampus.presentation.dto.BicycleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/api/accessPoint")
public class AccessPointController {

    @Autowired
    private AccessPointService accessPointService;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private BicycleService bicycleService;

    @GetMapping("/list")
    public ResponseEntity<List<AccessPointDTO>> listAccessPoints() {
        List<AccessPointDTO> accessPointDTOList = new ArrayList<>();

        accessPointService.listAccessPoints().forEach(accessPoint -> {
            AccessPointDTO dto = converterService.convertToDTO(accessPoint, AccessPointDTO.class);
            List<BicycleDTO> associatedBicycles = new ArrayList<>();

            bicycleService.listBicycles().forEach(bicycle -> {
                if (bicycle.getPoint_access_id() != null && bicycle.getPoint_access_id().getId() == accessPoint.getId()) {
                    BicycleDTO bicycleDTO = converterService.convertToDTO(bicycle, BicycleDTO.class);
                    bicycleDTO.setInstitution(accessPoint.getInstitution());
                    associatedBicycles.add(bicycleDTO);
                }
            });

            dto.setBicycleDTOS(associatedBicycles);
            accessPointDTOList.add(dto);
        });

        return ResponseEntity.ok().body(accessPointDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccessPointDTO> findAccessPointById(@PathVariable Long id) throws Exception {
        AccessPoint accessPoint = accessPointService.findAccessPointById(id);
        if (accessPoint == null) {
            return ResponseEntity.notFound().build();
        }
        AccessPointDTO accessPointDTO = converterService.convertToDTO(accessPoint, AccessPointDTO.class);
        return ResponseEntity.ok().body(accessPointDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<AccessPointDTO> saveAccessPoint(@RequestBody AccessPointDTO accessPointDTO) {
        AccessPoint accessPoint = converterService.convertToEntity(accessPointDTO, AccessPoint.class);
        accessPointService.saveAccessPoint(accessPoint);
        return ResponseEntity.ok().body(converterService.convertToDTO(accessPoint, AccessPointDTO.class));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccessPointDTO> updateAccessPoint(@PathVariable Long id, @RequestBody AccessPointDTO newAccessPointDTO) throws Exception {
        AccessPoint accessPoint = converterService.convertToEntity(newAccessPointDTO, AccessPoint.class);
        accessPointService.updateAccessPoint(id, accessPoint);

        for (AccessPointDTO point: listAccessPoints().getBody()) {
            if (point.getId() == accessPoint.getId()){
                return ResponseEntity.ok().body(point);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccessPoint(@PathVariable Long id) throws Exception {
        accessPointService.deleteAccessPoint(id);
        return ResponseEntity.ok("Access point deleted successfully.");
    }
}
