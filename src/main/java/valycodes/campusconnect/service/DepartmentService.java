package valycodes.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.DTO.DepartmentRequest;
import valycodes.campusconnect.DTO.DepartmentResponse;
import valycodes.campusconnect.mapper.DepartmentMapper;
import valycodes.campusconnect.model.Department;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.repository.DepartmentRepository;
import valycodes.campusconnect.repository.FacultyRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;


    @Autowired
    public DepartmentService(
            DepartmentRepository departmentRepository,
            FacultyRepository facultyRepository
    ) {
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
    }

    // Get all department items
    public List<DepartmentResponse> getDepartment() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toResponse) // convert each entity to DTO
                .collect(Collectors.toList());
    }
    // Add a new department item
    public void addNewDepartment(DepartmentRequest request) {
        Faculty faculty = facultyRepository.findById(request.getFacultyId())
                .orElseThrow(() ->
                        new IllegalStateException("Faculty not found")
                );
        // Check if a department with the same ID already exists
//        if (departmentRepository.existsByDepartmentName(department.getDepartmentName())) {
//            throw new IllegalStateException("Food already exists");
//        }

        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        department.setDepartmentAbbrev(request.getDepartmentAbbrev());
        department.setFaculty(faculty);
        departmentRepository.save(department);
        System.out.println("Added department: " + department);
    }

    // Delete a department item by ID
    public void deleteDepartment(Integer departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) {
            throw new IllegalStateException("Department with ID " + departmentId + " does not exist");
        }
        departmentRepository.deleteById(departmentId);
        System.out.println("Deleted department with ID: " + departmentId);
    }

    // Update a department item
    @Transactional
    public void updateDepartment(Integer departmentId, String name) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Department with ID " + departmentId + " does not exist"
                ));

        if (name != null && !name.isEmpty() && !Objects.equals(department.getDepartmentName(), name)) {
            department.setDepartmentName(name);
            System.out.println("Updated department name to: " + name);
        }

        // Add more fields to update here if needed (price, category, etc.)
    }
}
