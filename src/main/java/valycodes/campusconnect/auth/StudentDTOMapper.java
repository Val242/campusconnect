package valycodes.campusconnect.auth;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.CourseDTORequest;
import valycodes.campusconnect.model.StudentProfile;

import java.util.function.Function;

@Service
public class StudentDTOMapper implements Function<StudentProfile, StudentDTORequest> {

    @Override
    public StudentDTORequest apply(StudentProfile student){
        return new StudentDTORequest(
             student.getId(),
                student.getUser().getFirstname(),
                student.getUser().getLastname(),
                student.getUser().getEmail(),
                student.getMatriculationNumber(),
                student.getLevel(),
                student.getDepartment() != null ?student.getDepartment().getId() : null,
                student.getDepartment() != null
                        ? student.getDepartment().getDepartmentName() : null,
                student.getUser().getGender(),
                student.getUser().getPassword()
        );
    }
}
