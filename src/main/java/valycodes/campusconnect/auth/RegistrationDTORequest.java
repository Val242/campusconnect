package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Gender;
import valycodes.campusconnect.model.Role;

public record RegistrationDTORequest(
        String firstName,
        String lastName,
        String email,
        Role role,
        Gender gender,
        String password

) {
}
