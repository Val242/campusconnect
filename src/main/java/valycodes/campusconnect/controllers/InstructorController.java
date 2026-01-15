package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valycodes.campusconnect.auth.InstructorDTORequest;
import valycodes.campusconnect.auth.StudentDTORequest;
import valycodes.campusconnect.service.InstructorService;
import valycodes.campusconnect.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {
    private final InstructorService studentService;

    @Autowired
    public InstructorController(InstructorService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDTORequest> getInstructor(
            @PathVariable("id") Integer studentId
    ){
        InstructorDTORequest studentDTORequest = studentService.getInstructor(studentId);
        return ResponseEntity.ok(studentDTORequest);
    }
    @GetMapping
    public ResponseEntity<List<InstructorDTORequest>> getAllInstructors(){
        return ResponseEntity.ok(studentService.getAllInstructors());
    }
}
