package valycodes.campusconnect.auth;

public record StudentDTORequest(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Integer matriculationNumber,
        String level,
        Integer departmentId,
        String departmentName
) { }
