package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.response.ApiResponse;
import valycodes.campusconnect.service.FacultyService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<FacultyDTORequest> getFaculty(
            @PathVariable("id") Integer id
    ){
        FacultyDTORequest facultyDTO = facultyService.getFaculty(id);
        return  ResponseEntity.ok(facultyDTO);
    }
   @GetMapping
   public ResponseEntity<List<FacultyDTORequest>> getAllFaculties() {
       return ResponseEntity.ok(facultyService.getAllFaculties());
   }

    // Add a new food
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<FacultyDTORequest>> addNewFaculty(@RequestBody FacultyDTORequest request) {
        facultyService.addNewFaculty(request);
        System.out.println("Faculty added");
        return ResponseEntity.ok(new ApiResponse<>(200,"Faculty Added Successfully", request));
    }

    // Delete faculty by ID
    @PreAuthorize("hasRole('ADMIN')")
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
