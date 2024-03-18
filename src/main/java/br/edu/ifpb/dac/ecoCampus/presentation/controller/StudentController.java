package br.edu.ifpb.dac.ecoCampus.presentation.controller;

import br.edu.ifpb.dac.ecoCampus.business.Servers.ConverterService;
import br.edu.ifpb.dac.ecoCampus.business.Servers.StudentService;
import br.edu.ifpb.dac.ecoCampus.model.entity.Student;
import br.edu.ifpb.dac.ecoCampus.presentation.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ConverterService converterService;

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> listStudents() {
        List<StudentDTO> studentDTOList = studentService.listStudents().stream()
                .map(student -> converterService.convertToDTO(student, StudentDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(studentDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable Long id) throws Exception {
        Student student = studentService.findStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        StudentDTO studentDTO = converterService.convertToDTO(student, StudentDTO.class);
        return ResponseEntity.ok().body(studentDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) {
        Student student = converterService.convertToEntity(studentDTO, Student.class);
        studentService.saveStudent(student);
        return ResponseEntity.ok().body(converterService.convertToDTO(student, StudentDTO.class));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO newStudentDTO) throws Exception {
        Student student = converterService.convertToEntity(newStudentDTO, Student.class);
        studentService.updateStudent(id, student);
        newStudentDTO.setId(student.getId());
        return ResponseEntity.ok().body(converterService.convertToDTO(student, StudentDTO.class));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
