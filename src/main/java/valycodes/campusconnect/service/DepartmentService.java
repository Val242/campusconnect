package valycodes.campusconnect.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.dto.DepartmentDTORequest;

import valycodes.campusconnect.mapper.DepartmentDTOMapper;
import valycodes.campusconnect.model.Department;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.model.InstructorProfile;
import valycodes.campusconnect.repository.DepartmentRepository;
import valycodes.campusconnect.repository.FacultyRepository;
import valycodes.campusconnect.repository.InstructorRepository;

import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final InstructorRepository instructorRepository;
    private final DepartmentDTOMapper departmentDTOMapper;

    public DepartmentService(
            DepartmentRepository departmentRepository,
            FacultyRepository facultyRepository, InstructorRepository instructorRepository,
            DepartmentDTOMapper mapper
    ) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.instructorRepository = instructorRepository;
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
    public void addNewDepartment(DepartmentDTORequest requestDTO) {
        Faculty faculty = facultyRepository.findFacultyById(requestDTO.facultyId())
                .orElseThrow(()-> new IllegalStateException("Faculty not Found"));
        Department department = new Department();
        department.setDepartmentName(requestDTO.departmentName());
        department.setDepartmentAbbrev(requestDTO.departmentAbbrev());
        department.setFaculty(faculty);
        department.getFaculty().getId();
        Department savedDepartment = departmentRepository.save(department);
        departmentDTOMapper.apply(savedDepartment);
    }

    public void assignHeadOfDepartment(Integer departmentId, Integer instructorId){
       Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Faculty with ID " + departmentId + " does not exist"
                ));
        InstructorProfile instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Instructor with ID " + instructorId + " does not exist"
                ));
        if (department.getHeadOfDepartment() == null || !department.getHeadOfDepartment().getId().equals(instructorId))
        //Assign the new dean only if a dean doesn’t exist yet, or the dean is different from the current one.
        {
            System.out.println("Assigning dean...");
            department.setHeadOfDepartment(instructor);
            departmentRepository.saveAndFlush(department);
            System.out.println("The new dean of the department " + department.getDepartmentName() + " is " + instructor.getFirstname());

        }

        departmentDTOMapper.apply(department);
    }


}
