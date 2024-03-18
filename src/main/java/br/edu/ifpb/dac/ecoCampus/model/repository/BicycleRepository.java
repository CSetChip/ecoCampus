package br.edu.ifpb.dac.ecoCampus.model.repository;

import br.edu.ifpb.dac.ecoCampus.model.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepository extends JpaRepository<Bicycle, Long> {
}
