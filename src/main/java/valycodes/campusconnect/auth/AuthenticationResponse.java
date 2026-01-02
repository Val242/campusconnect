package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Role;

import java.util.Objects;

public class AuthenticationResponse {

    // Setter
    // Getter
    private String token;

    // Constructor that actually sets the token
    public AuthenticationResponse(String token) {
        this.token = token;
    }

    // Default constructor


    // Builder pattern
    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Builder inner class
    public static class AuthenticationResponseBuilder {
        private String token;

        public AuthenticationResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this.token);
        }


    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationResponse)) return false;
        AuthenticationResponse that = (AuthenticationResponse) o;
        return Objects.equals(getToken(), that.getToken());
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(getToken());
    }

    // toString method
    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
