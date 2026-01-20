package valycodes.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.dto.CourseDTORequest;
import valycodes.campusconnect.dto.DepartmentDTORequest;
import valycodes.campusconnect.mapper.CourseDTOMapper;
import valycodes.campusconnect.mapper.DepartmentDTOMapper;
import valycodes.campusconnect.model.Course;
import valycodes.campusconnect.model.Department;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.model.InstructorProfile;
import valycodes.campusconnect.repository.CourseRepository;
import valycodes.campusconnect.repository.DepartmentRepository;
import valycodes.campusconnect.repository.InstructorRepository;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final InstructorRepository instructorRepository;
    private final CourseDTOMapper courseDTOMapper;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository, InstructorRepository instructorRepository, CourseDTOMapper courseDTOMapper) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
        this.instructorRepository = instructorRepository;
        this.courseDTOMapper = courseDTOMapper;
    }

    public List<CourseDTORequest> getAllCourses(){
        return courseRepository.findAll()
                .stream()
                .map(courseDTOMapper)
                .toList();
    }

    @Transactional(readOnly = true)
    public CourseDTORequest getCourse(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId)
                .orElseThrow(()->
                        new IllegalStateException("Course not found"));
        return courseDTOMapper.apply(course);
    }
    public CourseDTORequest addNewCourse(CourseDTORequest requestDTO) {
       Department department = departmentRepository.findDepartmentById(requestDTO.departmentId())
                .orElseThrow(()-> new IllegalStateException("Department not Found"));
        Course course = new Course();
        course.setCourseCode(requestDTO.courseCode());
        course.setTitle(requestDTO.title());
        course.setCreditUnits(requestDTO.creditUnits());
        course.setLevel(requestDTO.level());
        course.setSemester(requestDTO.semester());
       course.setDepartment(department);
       course.getDepartment().getId();
        Course savedCourse = courseRepository.save(course);
        return courseDTOMapper.apply(savedCourse);
    }

    public void assignInstructorToCourse(Integer courseId, Integer instructorId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException(
                        "Course with ID " + courseId + " does not exist"
                ));

        InstructorProfile instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Instructor with ID " + instructorId + " does not exist"
                ));

        // Assign instructor only if not already assigned or different
        if (course.getInstructor() == null ||
                !course.getInstructor().getId().equals(instructorId)) {

            System.out.println("Assigning instructor...");
            course.setInstructor(instructor);
            courseRepository.save(course);
        }
    }


}
