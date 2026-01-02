package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
