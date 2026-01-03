package valycodes.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.model.Course;
import valycodes.campusconnect.repository.CourseRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Get all course items
    public List<Course> getCourse() {
        return courseRepository.findAll();
    }

    // Add a new course item
    public void addNewCourse(Course course) {
        // Check if a course with the same ID already exists
        if (courseRepository.existsByTitle(course.getTitle())) {
            throw new IllegalStateException("Food already exists");
        }
        courseRepository.save(course);

        courseRepository.save(course);
        System.out.println("Added course: " + course);
    }

    // Delete a course item by ID
    public void deleteCourse(Integer courseId) {
        boolean exists = courseRepository.existsById(courseId);
        if (!exists) {
            throw new IllegalStateException("Course with ID " + courseId + " does not exist");
        }
        courseRepository.deleteById(courseId);
        System.out.println("Deleted course with ID: " + courseId);
    }

    // Update a course item
    @Transactional
    public void updateCourse(Integer courseId, String name) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException(
                        "Course with ID " + courseId + " does not exist"
                ));

        if (name != null && !name.isEmpty() && !Objects.equals(course.getTitle(), name)) {
            course.setTitle(name);
            System.out.println("Updated course name to: " + name);
        }

        // Add more fields to update here if needed (price, category, etc.)
    }
}
