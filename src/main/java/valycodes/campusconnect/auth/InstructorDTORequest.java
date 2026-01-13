package valycodes.campusconnect.auth;

public record InstructorDTORequest(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Integer employeeNumber
       // String departmentName
){}
