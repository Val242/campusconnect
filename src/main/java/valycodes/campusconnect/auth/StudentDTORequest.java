package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Gender;
import valycodes.campusconnect.model.Role;

public record StudentDTORequest(
        Integer id,
        String firstname,
        String lastname,
        String email,
        Integer matriculationNumber,
        String level,
        Integer departmentId,
        String departmentName,
        Gender gender,
        Role role,
        String password
) { }
