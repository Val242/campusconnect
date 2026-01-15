package valycodes.campusconnect.mapper;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.model.Faculty;

import java.util.function.Function;

@Service
public class FacultyDTOMapper implements Function<Faculty, FacultyDTORequest> {

    @Override
    public FacultyDTORequest apply(Faculty faculty) {
        return new FacultyDTORequest(
                faculty.getFacultyName(),
                faculty.getFacultyAbbrev(),
                faculty.getDean()

        );
    }
}
