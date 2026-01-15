package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.StudentProfile;
import valycodes.campusconnect.model.User;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentProfile, Integer> {
    Optional<StudentProfile> findStudentById(Integer studentId);
}
