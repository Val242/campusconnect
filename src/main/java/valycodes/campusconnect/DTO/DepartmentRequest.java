package valycodes.campusconnect.DTO;

public class DepartmentRequest {

    private String departmentName;
    private String departmentAbbrev;
    private Integer facultyId;

    public DepartmentRequest() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public String getDepartmentAbbrev() {
        return departmentAbbrev;
    }
}

