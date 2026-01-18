package valycodes.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.dto.FacultyDTORequest;
import valycodes.campusconnect.mapper.FacultyDTOMapper;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.model.InstructorProfile;
import valycodes.campusconnect.repository.FacultyRepository;
import valycodes.campusconnect.repository.InstructorRepository;
import valycodes.campusconnect.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final UserRepository repository;
    private final InstructorRepository instructorRepository;
    private final FacultyDTOMapper facultyDTOMapper;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, UserRepository repository, InstructorRepository instructorRepository, FacultyDTOMapper facultyDTOMapper) {
        this.facultyRepository = facultyRepository;
        this.repository = repository;
        this.instructorRepository = instructorRepository;
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
    public void addNewFaculty(FacultyDTORequest requestDTO) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(requestDTO.facultyName());
        faculty.setFacultyAbbrev(requestDTO.facultyAbbrev());
        Faculty savedFaculty = facultyRepository.save(faculty);
        facultyDTOMapper.apply(savedFaculty);
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

    public void assignDean(Integer facultyId, Integer instructorId){
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Faculty with ID " + facultyId + " does not exist"
                ));
        InstructorProfile instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Instructor with ID " + instructorId + " does not exist"
                ));
        if (faculty.getDean() == null || !faculty.getDean().getId().equals(instructorId))
        //Assign the new dean only if a dean doesn’t exist yet, or the dean is different from the current one.
        {
            System.out.println("Assigning dean...");
            faculty.setDean(instructor);
            facultyRepository.saveAndFlush(faculty);
            System.out.println("The new dean of the faculty " + faculty.getFacultyName() + " is " + instructor.getFirstname());

        }

        facultyDTOMapper.apply(faculty);
    }
}

///Objects.equals(a, b)
//This is a null-safe comparison.
//It returns true if a and b are equal (including both being null).
//It returns false if they are different, or one is null.
