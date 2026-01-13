package valycodes.campusconnect.auth;


import org.springframework.stereotype.Service;
import valycodes.campusconnect.model.InstructorProfile;

import java.util.function.Function;

@Service
public class InstructorDTOMapper implements Function<InstructorProfile, InstructorDTORequest> {

    @Override
    public InstructorDTORequest apply(InstructorProfile instructor) {

        return new InstructorDTORequest(
                instructor.getId(),
                instructor.getUser().getFirstname(),
                instructor.getUser().getLastname(),
                instructor.getUser().getEmail(),
                instructor.getEmployeeNumber(),
                instructor.getDepartment() != null ?instructor.getDepartment().getId() : null,
               instructor.getDepartment() != null
                       ? instructor.getDepartment().getDepartmentName()
                       : null
                );
    }
}
