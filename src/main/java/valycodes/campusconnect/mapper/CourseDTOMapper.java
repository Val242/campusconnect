package valycodes.campusconnect.mapper;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.CourseDTORequest;
import valycodes.campusconnect.dto.DepartmentDTORequest;
import valycodes.campusconnect.model.Course;
import valycodes.campusconnect.model.Department;

import java.util.function.Function;

@Service
public class CourseDTOMapper implements Function<Course, CourseDTORequest> {
//“This object knows how to take one Course and turn it into one CourseDTORequest.”
    @Override
    public CourseDTORequest apply(Course course) {
        return new CourseDTORequest(
                course.getId(),
                course.getCourseCode(),
                course.getTitle(),
                course.getCreditUnits(),
                course.getLevel(),
                course.getSemester(),
                course.getDepartment() != null ? course.getDepartment().getId() : null
                // department.getFaculty() != null? department.getFaculty().getId(): null
        );
    }
}


