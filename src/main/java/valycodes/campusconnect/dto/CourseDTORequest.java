package valycodes.campusconnect.dto;

public record CourseDTORequest(
        Integer id,
        String courseCode,
        String title,
        Integer creditUnits,
        String level,
        String semester,
        String departmentName
) {}