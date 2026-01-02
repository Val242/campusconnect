package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.StudentProfile;

public interface StudentRepository extends JpaRepository<StudentProfile, Integer> {
}
