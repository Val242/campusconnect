package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import valycodes.campusconnect.DTO.DepartmentRequest;
import valycodes.campusconnect.DTO.DepartmentResponse;
import valycodes.campusconnect.response.ApiResponse;
import valycodes.campusconnect.service.DepartmentService;

import java.util.List;
@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/v1/department")

public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Get all foods
    @GetMapping
    public List<DepartmentResponse> getDepartment() {
        return departmentService.getDepartment();
    }

    // Add a new food
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentRequest>> addNewDepartment(@RequestBody DepartmentRequest request) {
        departmentService.addNewDepartment(request);
        System.out.println("Department added");
        return ResponseEntity.ok(new ApiResponse<>(200,"Department Added Successfully", request));


    }

    // Delete department by ID
    @DeleteMapping(path = "{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
    }

    // Update department by ID
    @PutMapping(path = "{departmentId}")
    public void updateDepartment(
            @PathVariable("departmentId") Integer departmentId,
            @RequestParam(required = false) String name
    ) {
        departmentService.updateDepartment(departmentId,
                name);
    }
}
