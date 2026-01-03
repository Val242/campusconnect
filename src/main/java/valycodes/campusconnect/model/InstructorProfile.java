package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "instructor_profiles")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorProfile {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(
            name = "user_id",
            unique = true
    )
    private User user;

    @Column(unique = true)
    private Integer employeeNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    private String faculty;
    private String office;   // optional, e.g., office location
    private String title;    // optional, e.g., Lecturer, Professor

    public Integer getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public Integer getEmployeeNumber() {
        return this.employeeNumber;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public Department getDepartment() {
        return this.department;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public String getOffice() {
        return this.office;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InstructorProfile)) return false;
        final InstructorProfile other = (InstructorProfile) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$employeeNumber = this.getEmployeeNumber();
        final Object other$employeeNumber = other.getEmployeeNumber();
        if (this$employeeNumber == null ? other$employeeNumber != null : !this$employeeNumber.equals(other$employeeNumber))
            return false;
        final Object this$courses = this.getCourses();
        final Object other$courses = other.getCourses();
        if (this$courses == null ? other$courses != null : !this$courses.equals(other$courses)) return false;
        final Object this$department = this.getDepartment();
        final Object other$department = other.getDepartment();
        if (this$department == null ? other$department != null : !this$department.equals(other$department))
            return false;
        final Object this$faculty = this.getFaculty();
        final Object other$faculty = other.getFaculty();
        if (this$faculty == null ? other$faculty != null : !this$faculty.equals(other$faculty)) return false;
        final Object this$office = this.getOffice();
        final Object other$office = other.getOffice();
        if (this$office == null ? other$office != null : !this$office.equals(other$office)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InstructorProfile;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $employeeNumber = this.getEmployeeNumber();
        result = result * PRIME + ($employeeNumber == null ? 43 : $employeeNumber.hashCode());
        final Object $courses = this.getCourses();
        result = result * PRIME + ($courses == null ? 43 : $courses.hashCode());
        final Object $department = this.getDepartment();
        result = result * PRIME + ($department == null ? 43 : $department.hashCode());
        final Object $faculty = this.getFaculty();
        result = result * PRIME + ($faculty == null ? 43 : $faculty.hashCode());
        final Object $office = this.getOffice();
        result = result * PRIME + ($office == null ? 43 : $office.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        return result;
    }

    public String toString() {
        return "InstructorProfile(id=" + this.getId() + ", user=" + this.getUser() + ", employeeNumber=" + this.getEmployeeNumber() + ", courses=" + this.getCourses() + ", department=" + this.getDepartment() + ", faculty=" + this.getFaculty() + ", office=" + this.getOffice() + ", title=" + this.getTitle() + ")";
    }
}
