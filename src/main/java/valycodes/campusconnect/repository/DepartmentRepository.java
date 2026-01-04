package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.Department;
import valycodes.campusconnect.model.Faculty;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findDepartmentById(Integer departmentId);
    boolean existsByDepartmentName(String departmentName);

    void deleteById(Integer departmentId);
}
