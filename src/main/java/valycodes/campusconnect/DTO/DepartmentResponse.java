package valycodes.campusconnect.DTO;

public class DepartmentResponse {

    private Integer id;
    private String departmentName;
    private String departmentAbbrev;
    private Integer facultyId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentAbbrev(String departmentAbbrev) {
        this.departmentAbbrev = departmentAbbrev;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

//    public void setHeadOfDepartmentId(Integer headOfDepartmentId) {
//        this.headOfDepartmentId = headOfDepartmentId;
//    }
//
//    public void setHeadOfDepartmentName(String headOfDepartmentName) {
//        this.headOfDepartmentName = headOfDepartmentName;
//    }

    private String facultyName;

//    private Integer headOfDepartmentId;   // optional
//    private String headOfDepartmentName;  // optional

    public DepartmentResponse() {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentAbbrev = departmentAbbrev;
        this.facultyId = facultyId;
        this.facultyName = facultyName;
//        this.headOfDepartmentId = headOfDepartmentId;
//        this.headOfDepartmentName = headOfDepartmentName;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getDepartmentAbbrev() {
        return this.departmentAbbrev;
    }

    public Integer getFacultyId() {
        return this.facultyId;
    }

    public String getFacultyName() {
        return this.facultyName;
    }

//    public Integer getHeadOfDepartmentId() {
//        return this.headOfDepartmentId;
//    }
//
//    public String getHeadOfDepartmentName() {
//        return this.headOfDepartmentName;
//    }
}
