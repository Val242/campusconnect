package valycodes.campusconnect.dto;



public record FacultyDTORequest(
        String facultyName,
        String facultyAbbrev,
        DeanDTORequest deanDTO
){
}
