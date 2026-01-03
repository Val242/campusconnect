package valycodes.campusconnect.auth;

import valycodes.campusconnect.model.Gender;
import valycodes.campusconnect.model.Role;

public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private Gender gender;

    //Instructor specific
    private Integer employeeNumber;
    private String title;

    //Student specific
    private Integer matriculationNumber;
    private String level;

    public RegisterRequest(String firstname, String lastname, String email, String password, Role role, Gender gender, Integer employeeNumber, String title, Integer matriculationNumber, String level) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.employeeNumber = employeeNumber;
        this.title = title;
        this.matriculationNumber = matriculationNumber;
        this.level = level;
    }

    public RegisterRequest() {

    }

    public static RegisterRequestBuilder builder() {
        return new RegisterRequestBuilder();
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RegisterRequest)) return false;
        final RegisterRequest other = (RegisterRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$firstname = this.getFirstname();
        final Object other$firstname = other.getFirstname();
        if (this$firstname == null ? other$firstname != null : !this$firstname.equals(other$firstname)) return false;
        final Object this$lastname = this.getLastname();
        final Object other$lastname = other.getLastname();
        if (this$lastname == null ? other$lastname != null : !this$lastname.equals(other$lastname)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RegisterRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $firstname = this.getFirstname();
        result = result * PRIME + ($firstname == null ? 43 : $firstname.hashCode());
        final Object $lastname = this.getLastname();
        result = result * PRIME + ($lastname == null ? 43 : $lastname.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "RegisterRequest(firstname=" + this.getFirstname() + ", lastname=" + this.getLastname() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", role=" + this.getRole() + ")";
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(Integer matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static class RegisterRequestBuilder {
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Gender gender;
        private Integer employeeNumber;
        private String title;
        private Integer matriculationNumber;
        private String level;
        private Role role;

        RegisterRequestBuilder() {
        }

        public RegisterRequestBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public RegisterRequestBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public RegisterRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterRequestBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public RegisterRequestBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public RegisterRequestBuilder employeeNumber(Integer employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public RegisterRequestBuilder title(String title) {
            this.title = title;
            return this;
        }

        public RegisterRequestBuilder matriculationNumber(Integer matriculationNumber) {
            this.matriculationNumber = matriculationNumber;
            return this;
        }

        public RegisterRequestBuilder level(String level) {
            this.level = level;
            return this;
        }


        public RegisterRequest build() {
            return new RegisterRequest(
                    this.firstname,
                    this.lastname,
                    this.email, this.password, this.role, this.gender, this.employeeNumber, this.title, this.matriculationNumber,this.level);
        }

        public String toString() {
            return "RegisterRequest.RegisterRequestBuilder(firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ")";
        }
    }
}
