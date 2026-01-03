package valycodes.campusconnect.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import valycodes.campusconnect.config.JwtService;
import valycodes.campusconnect.model.InstructorProfile;
import valycodes.campusconnect.model.Role;
import valycodes.campusconnect.model.StudentProfile;
import valycodes.campusconnect.model.User;
import valycodes.campusconnect.repository.InstructorRepository;
import valycodes.campusconnect.repository.StudentRepository;
import valycodes.campusconnect.repository.UserRepository;

@Service
public class AuthenticationService {
    // private final User user;
    private final UserRepository repository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, StudentRepository studentRepository, InstructorRepository instructorRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {

        if(repository.existsByEmail(request.getEmail())){
            throw new IllegalStateException("Email in use");
        }
        // User.builder().build();
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .gender(request.getGender())
                .build();

        repository.save(user);
        if(user.getRole() == Role.STUDENT) {
            var studentProfile = new StudentProfile();
            studentProfile.setUser(user);
            studentProfile.setMatriculationNumber(request.getMatriculationNumber());
            studentRepository.save(studentProfile);
        } else if(user.getRole() == Role.INSTRUCTOR) {
            var instructorProfile = new InstructorProfile();
            instructorProfile.setUser(user);
            instructorProfile.setEmployeeNumber(request.getEmployeeNumber());
            instructorRepository.save(instructorProfile);
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