package valycodes.campusconnect.mapper;

import org.springframework.stereotype.Component;
import valycodes.campusconnect.DTO.DepartmentResponse;
import valycodes.campusconnect.model.Department;

@Component
public class DepartmentMapper {
    public static DepartmentResponse toResponse(Department dept) {
        DepartmentResponse response = new DepartmentResponse();
        response.setId(dept.getId());
        response.setDepartmentName(dept.getDepartmentName());
        response.setDepartmentAbbrev(dept.getDepartmentAbbrev());
        if (dept.getFaculty() != null) {
            response.setFacultyName(dept.getFaculty().getFacultyName());
        }
//        if(dept.getHeadOfDepartment() != null) {
//            response.setHeadOfDepartmentName(
//                    dept.getHeadOfDepartment().getFirstname() + " " +
//                            dept.getHeadOfDepartment().getLastname()
//            );
        return response;
    }
    }

