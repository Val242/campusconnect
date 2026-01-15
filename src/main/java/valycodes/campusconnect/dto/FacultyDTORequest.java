package valycodes.campusconnect.dto;

import valycodes.campusconnect.model.InstructorProfile;

public record FacultyDTORequest(
        String facultyName,
        String facultyAbbrev,
        InstructorProfile dean
){
}
