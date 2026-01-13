package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Role;
import valycodes.campusconnect.model.User;

import java.util.function.Function;

public record AuthenticationDTOResponse (
        Integer id,
        String firstname,
        String lastname,
        String email,
        Role role

){
}
