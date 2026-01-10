package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Gender;

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
        String password
) { }
