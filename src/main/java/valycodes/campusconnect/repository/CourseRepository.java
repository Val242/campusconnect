package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.Course;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findCourseById(Integer courseId);
    boolean existsByTitle(String name);

    void deleteById(Integer courseId);
}
