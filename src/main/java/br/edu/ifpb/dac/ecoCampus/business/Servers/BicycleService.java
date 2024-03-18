package br.edu.ifpb.dac.ecoCampus.business.Servers;

import br.edu.ifpb.dac.ecoCampus.model.entity.AccessPoint;
import br.edu.ifpb.dac.ecoCampus.model.entity.Bicycle;
import br.edu.ifpb.dac.ecoCampus.model.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    @Autowired
    private DataManagerService dataManagerService;

    @Autowired
    private AccessPointService accessPointService;


    public List<Bicycle> listBicycles() {
        return bicycleRepository.findAll();
    }

    public Bicycle saveBicycle(Bicycle bicycle) {
        return bicycleRepository.save(bicycle);
    }

    public Bicycle saveBicycleAccessPoint(Bicycle bicycle, String institution) {

        if (institution == null || institution.isBlank())
            throw new IllegalArgumentException("Institution cannot be null or empty");

        AccessPoint accessPoint = accessPointService.findAccessPointByName(institution);
        if (accessPoint == null) throw new RuntimeException("Access Point not found for institution: " + institution);

        accessPoint.setBicycles(bicycle);
        bicycle.setPoint_access_id(accessPoint);
        return saveBicycle(bicycle);
    }


    public Bicycle findBicycleById(Long id) throws Exception {
        return bicycleRepository.findById(id).orElseThrow(() -> new Exception("Id Bicycle not found: " + id));
    }


    public Bicycle updateBicycle(Long id, Bicycle newBicycle) throws Exception {
        Bicycle bicycle = findBicycleById(id);

        bicycle.setBrand(newBicycle.getBrand());
        bicycle.setModel(newBicycle.getModel());
        bicycle.setColor(newBicycle.getColor());
        bicycle.setYear(newBicycle.getYear());

        bicycleRepository.save(bicycle);
        return bicycle;
    }

    public void deleteBicycle(Long id) throws Exception {
        bicycleRepository.deleteById(findBicycleById(id).getId());
    }
}
