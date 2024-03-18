package br.edu.ifpb.dac.ecoCampus.business.Servers;

import br.edu.ifpb.dac.ecoCampus.model.entity.Student;
import br.edu.ifpb.dac.ecoCampus.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DataManagerService dataManagerService;

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        student.setPassword(java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Id Student not found: " + id));
    }

    public Student updateStudent(Long id, Student newStudent) throws Exception {
        Student student = findStudentById(id);

        student.setEmail(newStudent.getEmail());
        student.setName(newStudent.getName());
        student.setInstitution(newStudent.getInstitution());
        student.setNumber(newStudent.getNumber());
        student.setRegistration(newStudent.getRegistration());

        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(Long id) throws Exception {
        studentRepository.deleteById(findStudentById(id).getId());
    }
}
