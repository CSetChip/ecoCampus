package com.farol.repository;

import com.farol.models.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
}
