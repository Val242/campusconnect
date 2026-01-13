package valycodes.campusconnect.auth;

public record RegistrationWrapper(
        RegistrationDTORequest registrationDTORequest,
        StudentDTORequest studentDTORequest,
        InstructorDTORequest instructorDTORequest
) {
}
