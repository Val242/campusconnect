package valycodes.campusconnect.auth;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.CourseDTORequest;
import valycodes.campusconnect.model.User;

import java.util.function.Function;

@Service
public class RegistrationDTOMapper implements Function<User, RegistrationDTORequest> {
    //“This object knows how to take one Course and turn it into one CourseDTORequest.”
    @Override
    public RegistrationDTORequest apply(User user) {
        return new RegistrationDTORequest(
              user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole(),
                user.getGender(),
               user.getPassword()
                // department.getFaculty() != null? department.getFaculty().getId(): null
        );
    }

}


