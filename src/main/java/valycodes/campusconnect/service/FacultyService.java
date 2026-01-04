package valycodes.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valycodes.campusconnect.model.Faculty;
import valycodes.campusconnect.repository.FacultyRepository;

import java.util.List;
import java.util.Objects;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // Get all faculty items
    public List<Faculty> getFaculty() {
        return facultyRepository.findAll();
    }

    // Add a new faculty item
    public void addNewFaculty(Faculty faculty) {
        // Check if a faculty with the same ID already exists
        if (facultyRepository.existsByFacultyName(faculty.getFacultyName())) {
            throw new IllegalStateException("Faculty already exists");
        }
        facultyRepository.save(faculty);
        System.out.println("Added faculty: " + faculty);
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
