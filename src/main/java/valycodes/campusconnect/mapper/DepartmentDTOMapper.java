package valycodes.campusconnect.mapper;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.dto.DepartmentDTORequest;
import valycodes.campusconnect.model.Department;

import java.util.function.Function;

@Service
public class DepartmentDTOMapper implements Function<Department, DepartmentDTORequest> {

    @Override
    public DepartmentDTORequest apply(Department department) {
        return new DepartmentDTORequest(
                department.getDepartmentName(),
                department.getDepartmentAbbrev(),
                department.getFaculty().getId()
        );
    }
}
