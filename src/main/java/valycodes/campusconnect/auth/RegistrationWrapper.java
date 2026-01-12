package valycodes.campusconnect.auth;

public class RegistrationWrapper {
    RegistrationDTORequest registrationDTORequest;
    StudentDTORequest studentDTORequest;

    public RegistrationWrapper(StudentDTORequest studentDTORequest, RegistrationDTORequest registrationDTORequest) {
        this.studentDTORequest = studentDTORequest;
        this.registrationDTORequest = registrationDTORequest;
    }

    public RegistrationDTORequest getRegistrationDTORequest() {
        return this.registrationDTORequest;
    }

    public StudentDTORequest getStudentDTORequest() {
        return this.studentDTORequest;
    }

    public void setRegistrationDTORequest(RegistrationDTORequest registrationDTORequest) {
        this.registrationDTORequest = registrationDTORequest;
    }

    public void setStudentDTORequest(StudentDTORequest studentDTORequest) {
        this.studentDTORequest = studentDTORequest;
    }
}
