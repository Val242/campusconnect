package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Gender;
import valycodes.campusconnect.model.Role;

public record RegistrationDTORequest(
        String firstname,
        String lastname,
        String email,
        Role role,
        Gender gender,
        String password

) {
}
