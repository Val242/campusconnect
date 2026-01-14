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
import valycodes.campusconnect.repository.CourseRepository;
import valycodes.campusconnect.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final CourseDTOMapper courseDTOMapper;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository, CourseDTOMapper courseDTOMapper) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
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

}
