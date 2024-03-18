package br.edu.ifpb.dac.ecoCampus.business.Servers;

import br.edu.ifpb.dac.ecoCampus.model.entity.AccessPoint;
import br.edu.ifpb.dac.ecoCampus.model.repository.AccessPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessPointService {

    @Autowired
    private AccessPointRepository pointAccessRepository;

    @Autowired
    private DataManagerService dataManagerService;

    public List<AccessPoint> listAccessPoints() {
        return pointAccessRepository.findAll();
    }

    public AccessPoint saveAccessPoint(AccessPoint accessPoint) {
        return pointAccessRepository.save(accessPoint);
    }

    public AccessPoint findAccessPointById(Long id) throws Exception {
        return pointAccessRepository.findById(id).orElseThrow(() -> new Exception("Id Access Point not found: " + id));
    }

    public AccessPoint findAccessPointByName(String institution) {
        for (AccessPoint point : listAccessPoints()) {
            if (point.getInstitution().equalsIgnoreCase(institution)) {
                return point;
            }
        }
        return null;
    }

    public AccessPoint updateAccessPoint(Long id, AccessPoint newAccessPoint) throws Exception {
        AccessPoint accessPoint = findAccessPointById(id);

        accessPoint.setInstitution(newAccessPoint.getInstitution());
        accessPoint.setAddress(newAccessPoint.getAddress());

        pointAccessRepository.save(accessPoint);
        return accessPoint;
    }

    public void deleteAccessPoint(Long id) throws Exception {
        pointAccessRepository.deleteById(findAccessPointById(id).getId());
    }

}
