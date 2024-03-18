package br.edu.ifpb.dac.ecoCampus.model.repository;

import br.edu.ifpb.dac.ecoCampus.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
