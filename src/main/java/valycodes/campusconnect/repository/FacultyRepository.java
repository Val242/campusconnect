package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.Faculty;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Optional<Faculty> findFacultyById(Integer facultyId);
    boolean existsByFacultyName(String facultyName);

    void deleteById(Integer facultyId);
}
