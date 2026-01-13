package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.User;

import java.util.function.Function;

public class AuthenticationResponseDTOMapper implements Function<User, AuthenticationDTOResponse> {
    @Override
    public AuthenticationDTOResponse apply(User user) {
        return new AuthenticationDTOResponse(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole()

        );
    }
}
