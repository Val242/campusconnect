package valycodes.campusconnect.service;

import org.springframework.stereotype.Service;
import valycodes.campusconnect.auth.InstructorDTOMapper;
import valycodes.campusconnect.auth.InstructorDTORequest;
import valycodes.campusconnect.model.InstructorProfile;
import valycodes.campusconnect.repository.InstructorRepository;

import java.util.List;

@Service

public class InstructorService {
    private  final InstructorRepository instructorRepository;
    private final InstructorDTOMapper instructorDTOMapper;

    public InstructorService(InstructorRepository instructorRepository, InstructorDTOMapper instructorDTOMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorDTOMapper = instructorDTOMapper;
    }

    public List<InstructorDTORequest> getAllInstructors(){
        return instructorRepository.findAll()
                .stream()
                .map(instructorDTOMapper)
                .toList();
    }
    public InstructorDTORequest getInstructor(Integer instructorId){
        InstructorProfile instructor = instructorRepository
                .findInstructorById(instructorId)
                .orElseThrow(()->
                        new IllegalStateException("Instructor not found"));
        return instructorDTOMapper.apply(instructor);
    }
}
