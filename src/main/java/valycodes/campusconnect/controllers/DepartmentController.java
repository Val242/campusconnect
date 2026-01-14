package valycodes.campusconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import valycodes.campusconnect.dto.DepartmentDTORequest;
import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.response.ApiResponse;
import valycodes.campusconnect.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")

public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Get one department
    @GetMapping("/{id}")
    public  ResponseEntity<DepartmentDTORequest> getDepartment(
            @PathVariable("id") Integer id
    ){
        DepartmentDTORequest departmentDTO = departmentService.getDepartment(id);
        return  ResponseEntity.ok(departmentDTO);
    }
    @GetMapping
    public  ResponseEntity<List<DepartmentDTORequest>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    // Add a new food
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentDTORequest>> addNewDepartment(@RequestBody DepartmentDTORequest request) {
        departmentService.addNewDepartment(request);
        System.out.println("Department added");
        return ResponseEntity.ok(new ApiResponse<>(200,"Department Added Successfully", request));
    }

    // Delete department by ID
//    @DeleteMapping(path = "{departmentId}")
//    public void deleteDepartment(@PathVariable("departmentId") Integer departmentId) {
//        departmentService.deleteDepartment(departmentId);
//    }
//
//    // Update department by ID
//    @PutMapping(path = "{departmentId}")
//    public void updateDepartment(
//            @PathVariable("departmentId") Integer departmentId,
//            @RequestParam(required = false) String name
//    ) {
//        departmentService.updateDepartment(departmentId,
//                name);
//    }
}
