package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.response.ApiResponse;
import valycodes.campusconnect.service.FacultyService;

import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // Get all foods
    @GetMapping
    public List<Faculty> getFaculty() {
        return facultyService.getFaculty();
    }

    // Add a new food
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Faculty>> addNewFaculty(@RequestBody Faculty faculty) {
        facultyService.addNewFaculty(faculty);
        System.out.println("Faculty added");
        return ResponseEntity.ok(new ApiResponse<>(200,"Faculty Added Successfully", faculty));


    }

    // Delete faculty by ID
    @DeleteMapping(path = "{facultyId}")
    public void deleteFaculty(@PathVariable("facultyId") Integer facultyId) {
        facultyService.deleteFaculty(facultyId);
    }

    // Update faculty by ID
    @PutMapping(path = "{facultyId}")
    public void updateFaculty(
            @PathVariable("facultyId") Integer facultyId,
            @RequestParam(required = false) String name
    ) {
        facultyService.updateFaculty(facultyId,
                name);
    }
}
