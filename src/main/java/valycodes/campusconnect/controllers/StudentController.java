package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valycodes.campusconnect.auth.StudentDTORequest;
import valycodes.campusconnect.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTORequest> getStudent(
            @PathVariable("id") Integer studentId
    ){
        StudentDTORequest studentDTORequest = studentService.getStudent(studentId);
        return ResponseEntity.ok(studentDTORequest);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTORequest>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

}
