package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.InstructorProfile;


import java.util.Optional;

public interface InstructorRepository extends JpaRepository<InstructorProfile, Integer> {
    Optional<InstructorProfile> findInstructorById(Integer instructorId);
}
