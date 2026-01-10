package valycodes.campusconnect.dto;

public record CourseDTORequest(
        Integer id,
        String courseCode,
        String title,
        Integer creditUnits,
        String level,
        String semester,
        Integer departmentId
) {}

//→ Everything (constructor, getters, equals(), hashCode(), toString()) is automatically generated — you write one
//line instead of 20+.