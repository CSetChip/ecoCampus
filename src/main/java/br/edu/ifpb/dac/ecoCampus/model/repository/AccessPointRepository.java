package br.edu.ifpb.dac.ecoCampus.model.repository;

import br.edu.ifpb.dac.ecoCampus.model.entity.AccessPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessPointRepository extends JpaRepository<AccessPoint, Long> {
}
