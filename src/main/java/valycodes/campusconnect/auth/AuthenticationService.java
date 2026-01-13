package valycodes.campusconnect.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import valycodes.campusconnect.config.JwtService;
import valycodes.campusconnect.model.*;
import valycodes.campusconnect.repository.DepartmentRepository;
import valycodes.campusconnect.repository.InstructorRepository;
import valycodes.campusconnect.repository.StudentRepository;
import valycodes.campusconnect.repository.UserRepository;

@Service
public class AuthenticationService {
    // private final User user;
    private final UserRepository repository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, StudentRepository studentRepository, InstructorRepository instructorRepository, DepartmentRepository departmentRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.departmentRepository = departmentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegistrationWrapper registrationWrapper) {

        RegistrationDTORequest reg = registrationWrapper.registrationDTORequest();

        if(repository.existsByEmail(registrationWrapper.registrationDTORequest().email())){
            throw new IllegalStateException("Email in use");
        }
        User user = new User();
        user.setFirstname(reg.firstname());
        user.setLastname(reg.lastname());
        user.setEmail(reg.email());
        user.setRole(reg.role());
        user.setGender(reg.gender());
        user.setPassword(passwordEncoder.encode(reg.password()));

        repository.save(user);
        if(user.getRole() == Role.STUDENT) {
            StudentDTORequest studentDTO = registrationWrapper.studentDTORequest();
            if (studentDTO == null) {
                throw new IllegalStateException("Student data is required for STUDENT role");
            }
          Department department = departmentRepository.findDepartmentById(studentDTO.departmentId())
                  .orElseThrow(()-> new IllegalStateException("Department not Found"));
         StudentProfile student = new StudentProfile();
            student.setUser(user);
            student.setFirstname(user.getFirstname());
            student.setLastname(user.getLastname());
            student.setEmail(user.getEmail());
            student.setGender(user.getGender());
            student.setMatriculationNumber(student.getMatriculationNumber());
            student.setLevel(student.getLevel());
           student.setDepartment(department);
           student.getDepartment().getDepartmentName();
            studentRepository.save(student);
        } else if(user.getRole() == Role.INSTRUCTOR) {
            InstructorDTORequest instructorDTO = registrationWrapper.instructorDTORequest();
            if (instructorDTO == null) {
                throw new IllegalStateException("Instructor data is required for INSTRUCTOR role");
            }
            Department department = departmentRepository.findDepartmentById(instructorDTO.departmentId())
                    .orElseThrow(()-> new IllegalStateException("Department not Found"));
            InstructorProfile instructor = new InstructorProfile();
            instructor.setUser(user);
           instructor.setFirstname(user.getFirstname());
           instructor.setLastname(user.getLastname());
           instructor.setEmail(user.getEmail());
           instructor.setGender(user.getGender());
           instructor.setEmployeeNumber(instructor.getEmployeeNumber());
         instructor.setDepartment(department);
         instructor.getDepartment().getDepartmentName();
            instructorRepository.save(instructor);
        }

        var jwtToken = jwtService.generateToken(user);
        System.out.println("JWT GENERATED" + jwtToken);



        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}