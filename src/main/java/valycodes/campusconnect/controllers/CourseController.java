package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import valycodes.campusconnect.model.Course;
import valycodes.campusconnect.response.ApiResponse;
import valycodes.campusconnect.service.CourseService;

import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v1/course")

public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Get all foods
    @GetMapping
    public List<Course> getCourse() {
        return courseService.getCourse();
    }

    // Add a new food
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addNewCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
        System.out.println("Course added");
        return ResponseEntity.ok(new ApiResponse<>(200,"Course Added Successfully", course));


    }

    // Delete course by ID
    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer courseId) {
        courseService.deleteCourse(courseId);
    }

    // Update course by ID
    @PutMapping(path = "{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Integer courseId,
            @RequestParam(required = false) String name
    ) {
        courseService.updateCourse(courseId,
                name);
    }
}
