package valycodes.campusconnect.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.dto.DepartmentDTORequest;

import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.mapper.DepartmentDTOMapper;
import valycodes.campusconnect.model.Department;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.repository.DepartmentRepository;
import valycodes.campusconnect.repository.FacultyRepository;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final DepartmentDTOMapper departmentDTOMapper;

    public DepartmentService(
            DepartmentRepository departmentRepository,
            FacultyRepository facultyRepository,
            DepartmentDTOMapper mapper
    ) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentDTOMapper = mapper;
    }
    public List<DepartmentDTORequest> getAllDepartments(){
      return   departmentRepository.findAll()
                .stream()
                .map(departmentDTOMapper)
                .toList();
    }
    @Transactional(readOnly = true)
    public DepartmentDTORequest getDepartment(Integer departmentId) {
        Department department = departmentRepository.findDepartmentById(departmentId)
                .orElseThrow(()->
                        new IllegalStateException("Faculty not found"));
        return departmentDTOMapper.apply(department);
    }
    public DepartmentDTORequest addNewDepartment(DepartmentDTORequest requestDTO) {
        Faculty faculty = facultyRepository.findFacultyById(requestDTO.facultyId())
                .orElseThrow(()-> new IllegalStateException("Faculty not Found"));
        Department department = new Department();
        department.setDepartmentName(requestDTO.departmentName());
        department.setDepartmentAbbrev(requestDTO.departmentAbbrev());
        department.setFaculty(faculty);
        department.getFaculty().getId();
        Department savedDepartment = departmentRepository.save(department);
        return departmentDTOMapper.apply(savedDepartment);
    }


}
