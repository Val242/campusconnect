package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import valycodes.campusconnect.dto.CourseDTORequest;

import valycodes.campusconnect.dto.DepartmentDTORequest;
import valycodes.campusconnect.model.Course;
import valycodes.campusconnect.response.ApiResponse;
import valycodes.campusconnect.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")

public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<CourseDTORequest> getCourse(
            @PathVariable("id") Integer id
    ){
        CourseDTORequest courseDTO = courseService.getCourse(id);
        return  ResponseEntity.ok(courseDTO);
    }
    @GetMapping
    public ResponseEntity<List<CourseDTORequest>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // Add a new food
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<CourseDTORequest>> addNewCourse(@RequestBody CourseDTORequest request) {
        courseService.addNewCourse(request);
        System.out.println("Course added");
        return ResponseEntity.ok(new ApiResponse<>(200,"Course Added Successfully", request));
    }
}
