package br.edu.ifpb.dac.ecoCampus.presentation.controller;

import br.edu.ifpb.dac.ecoCampus.business.Servers.BicycleService;
import br.edu.ifpb.dac.ecoCampus.business.Servers.ConverterService;
import br.edu.ifpb.dac.ecoCampus.model.entity.AccessPoint;
import br.edu.ifpb.dac.ecoCampus.model.entity.Bicycle;
import br.edu.ifpb.dac.ecoCampus.presentation.dto.BicycleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bicycle")
public class BicycleController {

    @Autowired
    private ConverterService converterService;

    @Autowired
    private BicycleService bicycleService;


    @GetMapping("/list")
    public ResponseEntity<List<BicycleDTO>> listBicycles() {
        List<BicycleDTO> bicycleDTOList = new ArrayList<>();
        bicycleService.listBicycles().forEach(bicycle -> {
            BicycleDTO dto = converterService.convertToDTO(bicycle, BicycleDTO.class);
            AccessPoint accessPoint = bicycle.getPoint_access_id();
            if (accessPoint != null) {
                dto.setInstitution(accessPoint.getInstitution());
            }
            bicycleDTOList.add(dto);
        });

        return ResponseEntity.ok().body(bicycleDTOList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BicycleDTO> findBicycleById(@PathVariable Long id) throws Exception {
        Bicycle bicycle = bicycleService.findBicycleById(id);

        if (bicycle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(converterService.convertToDTO(bicycle, BicycleDTO.class));
    }

    @PostMapping("/save")
    public ResponseEntity<BicycleDTO> saveBicycle(@RequestBody BicycleDTO bicycleDTO) {
        Bicycle bicycle = converterService.convertToEntity(bicycleDTO, Bicycle.class);
        bicycleService.saveBicycleAccessPoint(bicycle, bicycleDTO.getInstitution());

        bicycleDTO = converterService.convertToDTO(bicycle, BicycleDTO.class);
        bicycleDTO.setInstitution(bicycle.getPoint_access_id().getInstitution());

        return ResponseEntity.ok().body(bicycleDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BicycleDTO> updateBicycle(@PathVariable Long id, @RequestBody BicycleDTO newBicycleDTO) throws Exception {

        Bicycle bicycle = converterService.convertToEntity(newBicycleDTO, Bicycle.class);

        bicycle = bicycleService.saveBicycleAccessPoint(bicycle, newBicycleDTO.getInstitution());

        bicycleService.updateBicycle(id, bicycle);

        newBicycleDTO = converterService.convertToDTO(bicycle, BicycleDTO.class);
        newBicycleDTO.setInstitution(bicycle.getPoint_access_id().getInstitution());

        return ResponseEntity.ok().body(newBicycleDTO);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBicycle(@PathVariable Long id) throws Exception {
        bicycleService.deleteBicycle(id);
        return ResponseEntity.ok("Bicycle deleted successfully.");
    }
}
