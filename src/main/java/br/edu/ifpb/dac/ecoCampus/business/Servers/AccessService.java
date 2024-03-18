package br.edu.ifpb.dac.ecoCampus.business.Servers;

import br.edu.ifpb.dac.ecoCampus.model.entity.Access;
import br.edu.ifpb.dac.ecoCampus.model.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccessService {

    @Autowired
    private AccessRepository accessRepository;

    @Autowired
    private DataManagerService dataManagerService;

    public List<Access> listAccess() {
        return accessRepository.findAll();
    }

    public Access saveAccess(Access access) {
        return accessRepository.save(access);
    }

    public Access findAccessById(Long id) throws Exception {
        return accessRepository.findById(id).orElseThrow(() -> new Exception("Id Access not found: " + id));
    }

    public Access updateAccess(Long id, Access newAccess) throws Exception {
        Access access = findAccessById(id);

        access.setEnd_time(LocalDateTime.now());
        access.setArrival_point(newAccess.getArrival_point());

        return accessRepository.save(access);
    }

    public void deleteAccess(Long id) throws Exception {
        accessRepository.deleteById(findAccessById(id).getId());
    }
}
