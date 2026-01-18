package valycodes.campusconnect.dto;

public record DepartmentDTORequest(
        String departmentName,
        String departmentAbbrev,
        Integer facultyId,
        HodDTORequest hodDTO
) {
}
