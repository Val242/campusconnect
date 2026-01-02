package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.InstructorProfile;

public interface InstructorRepository extends JpaRepository<InstructorProfile, Integer> {
}
