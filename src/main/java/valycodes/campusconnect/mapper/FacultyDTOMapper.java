package valycodes.campusconnect.mapper;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.DeanDTORequest;
import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.model.InstructorProfile;

import java.util.function.Function;

@Service
public class FacultyDTOMapper implements Function<Faculty, FacultyDTORequest> {

    @Override
    public FacultyDTORequest apply(Faculty faculty) {
        DeanDTORequest deanDTO = null;

        if (faculty.getDean() != null) {
            InstructorProfile dean = faculty.getDean();
            deanDTO = new DeanDTORequest(
                    dean.getId(),
                    dean.getFirstname(),
                    dean.getLastname(),
                    dean.getEmail()
            );
        }
        return new FacultyDTORequest(
                faculty.getFacultyName(),
                faculty.getFacultyAbbrev(),
                deanDTO

        );
    }
}
