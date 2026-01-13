package valycodes.campusconnect.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valycodes.campusconnect.model.Role;
import valycodes.campusconnect.response.ApiResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> register(
            @RequestBody RegistrationWrapper request
    ) {


        AuthenticationResponse authResponse = service.register(request);

        return ResponseEntity.ok(new ApiResponse<>(
                200,
                "User registered and authenticated successfully",
                authResponse
        ));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> authenticate(
            @RequestBody AuthenticationRequest request
    ){
       AuthenticationResponse authResponse = service.authenticate(request);

       ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>(
               200,
               "Authentication Successful",
               authResponse
       );
       return ResponseEntity.ok(apiResponse);
       // return ResponseEntity.ok((service.authenticate(request)));
    }
}
