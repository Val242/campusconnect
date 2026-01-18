package valycodes.campusconnect.mapper;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.DeanDTORequest;
import valycodes.campusconnect.dto.DepartmentDTORequest;
import valycodes.campusconnect.dto.HodDTORequest;
import valycodes.campusconnect.model.Department;
import valycodes.campusconnect.model.InstructorProfile;

import java.util.function.Function;

@Service
public class DepartmentDTOMapper implements Function<Department, DepartmentDTORequest> {

    @Override
    public DepartmentDTORequest apply(Department department) {
        HodDTORequest hodDTO = null;

        if (department.getHeadOfDepartment() != null) {
            InstructorProfile hod = department.getHeadOfDepartment();
            hodDTO = new HodDTORequest(
                    hod.getId(),
                    hod.getFirstname(),
                    hod.getLastname(),
                    hod.getEmail()
            );
        }
        return new DepartmentDTORequest(
                department.getDepartmentName(),
                department.getDepartmentAbbrev(),
                department.getFaculty() != null? department.getFaculty().getId(): null,
                hodDTO
        );
    }
}
