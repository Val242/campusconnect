package valycodes.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.mapper.FacultyDTOMapper;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.model.InstructorProfile;
import valycodes.campusconnect.repository.FacultyRepository;
import valycodes.campusconnect.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final UserRepository repository;
    private final FacultyDTOMapper facultyDTOMapper;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, UserRepository repository, FacultyDTOMapper facultyDTOMapper) {
        this.facultyRepository = facultyRepository;
        this.repository = repository;
        this.facultyDTOMapper = facultyDTOMapper;
    }


    public List<FacultyDTORequest> getAllFaculties(){

        return  facultyRepository.findAll()
                .stream()
                .map(facultyDTOMapper)
                .toList();
    }
    // Get one faculty
    @Transactional(readOnly = true)
    public FacultyDTORequest getFaculty(Integer facultyId) {
        Faculty faculty = facultyRepository.findFacultyById(facultyId)
                .orElseThrow(()->
                        new IllegalStateException("Faculty not found"));
        return facultyDTOMapper.apply(faculty);
    }

    // Add a new faculty item
    public FacultyDTORequest addNewFaculty(FacultyDTORequest requestDTO) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(requestDTO.facultyName());
        faculty.setFacultyAbbrev(requestDTO.facultyAbbrev());
        Faculty savedFaculty = facultyRepository.save(faculty);
        return facultyDTOMapper.apply(savedFaculty);
    }


    // Delete a faculty item by ID
    public void deleteFaculty(Integer facultyId) {
        boolean exists = facultyRepository.existsById(facultyId);
        if (!exists) {
            throw new IllegalStateException("Faculty with ID " + facultyId + " does not exist");
        }
        facultyRepository.deleteById(facultyId);
        System.out.println("Deleted faculty with ID: " + facultyId);
    }

    // Update a faculty item
    @Transactional
    public void updateFaculty(Integer facultyId, String name) {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Faculty with ID " + facultyId + " does not exist"
                ));

        if (name != null && !name.isEmpty() && !Objects.equals(faculty.getFacultyName(), name)) {
            faculty.setFacultyName(name);
            System.out.println("Updated faculty name to: " + name);
        }

        // Add more fields to update here if needed (price, category, etc.)
    }
}
