package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(mappedBy = "studentProfile")
    private User user;

    private String firstname;
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private Integer matriculationNumber;
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    private String level;


    public Integer getId() {
        return this.id;
    }

//    public User getUser() {
//        return this.user;
//    }

    public Integer getMatriculationNumber() {
        return this.matriculationNumber;
    }

    public Department getDepartment() {
        return this.department;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public User user() {
        return this.user;
    }

    public String getLevel() {
        return this.level;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void setMatriculationNumber(Integer matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StudentProfile)) return false;
        final StudentProfile other = (StudentProfile) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$matriculationNumber = this.getMatriculationNumber();
        final Object other$matriculationNumber = other.getMatriculationNumber();
        if (this$matriculationNumber == null ? other$matriculationNumber != null : !this$matriculationNumber.equals(other$matriculationNumber))
            return false;
        final Object this$department = this.getDepartment();
        final Object other$department = other.getDepartment();
        if (this$department == null ? other$department != null : !this$department.equals(other$department))
            return false;
        final Object this$courses = this.getCourses();
        final Object other$courses = other.getCourses();
        if (this$courses == null ? other$courses != null : !this$courses.equals(other$courses)) return false;
        final Object this$level = this.getLevel();
        final Object other$level = other.getLevel();
        if (this$level == null ? other$level != null : !this$level.equals(other$level)) return false;
        return true;
    }


    public User getUser() {
        return this.user;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StudentProfile;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
//        final Object $user = this.getUser();
//        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $matriculationNumber = this.getMatriculationNumber();
        result = result * PRIME + ($matriculationNumber == null ? 43 : $matriculationNumber.hashCode());
        final Object $department = this.getDepartment();
        result = result * PRIME + ($department == null ? 43 : $department.hashCode());
        final Object $courses = this.getCourses();
        result = result * PRIME + ($courses == null ? 43 : $courses.hashCode());
        final Object $level = this.getLevel();
        result = result * PRIME + ($level == null ? 43 : $level.hashCode());
        return result;
    }

    public String toString() {
        return "StudentProfile(id=" + this.getId() + ", user=" + ", matriculationNumber=" + this.getMatriculationNumber() + ", department=" + this.getDepartment() + ", courses=" + this.getCourses() + ", level=" + this.getLevel() + ")";
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}