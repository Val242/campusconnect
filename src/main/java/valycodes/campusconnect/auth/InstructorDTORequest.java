package valycodes.campusconnect.auth;

public record InstructorDTORequest(
        Integer id,
        String firstname,
        String lastname,
        String email,
        Integer employeeNumber,
        Integer departmentId,
       String department
){}
