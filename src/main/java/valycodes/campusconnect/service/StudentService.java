package valycodes.campusconnect.service;

import valycodes.campusconnect.auth.StudentDTOMapper;
import valycodes.campusconnect.auth.StudentDTORequest;
import valycodes.campusconnect.model.StudentProfile;
import valycodes.campusconnect.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentDTOMapper studentDTOMapper;

    public StudentService(StudentRepository studentRepository, StudentDTOMapper studentDTOMapper) {
        this.studentRepository = studentRepository;
        this.studentDTOMapper = studentDTOMapper;
    }

    public List<StudentDTORequest> getAllStudents(){
        return studentRepository.findAll()
                .stream()
                .map(studentDTOMapper)
                .toList();
    }
    public StudentDTORequest getStudent(Integer studentId){
        StudentProfile student = studentRepository.findStudentById(studentId)
                .orElseThrow(()->
                        new IllegalStateException("Student not found"));
        return studentDTOMapper.apply(student);
    }
}
