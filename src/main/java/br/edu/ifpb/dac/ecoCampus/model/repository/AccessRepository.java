package br.edu.ifpb.dac.ecoCampus.model.repository;

import br.edu.ifpb.dac.ecoCampus.model.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Long> {
}
