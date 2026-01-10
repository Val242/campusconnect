package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "department")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            unique = true,
            nullable = false
    )
    private String departmentName;
    @Column(
            unique = true,
            length = 10
    )
    private String departmentAbbrev;
    @OneToOne()
    @JoinColumn(
            name = "head_of_department_id",
            referencedColumnName = "id",
            unique = true
    )
    private InstructorProfile headOfDepartment;

    @ManyToOne(
            optional = false,//it enforces the NOT NULL constraint
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "faculty_id",
            nullable = false
    )
    private Faculty faculty;
    @OneToMany(
            fetch = FetchType.LAZY
    )
    private List<Course> courses;

    @OneToMany(mappedBy = "department")
    private List<StudentProfile> students = new ArrayList<>();

    @ManyToMany
    @OrderBy("createdAt ASC")
    @JoinTable(
            name = "department_instructors",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private Set<InstructorProfile> instructors = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Integer getId() {
        return this.id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getDepartmentAbbrev() {
        return this.departmentAbbrev;
    }

    public InstructorProfile getHeadOfDepartment() {
        return this.headOfDepartment;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public List<StudentProfile> getStudents() {
        return this.students;
    }

    public Set<InstructorProfile> getInstructors() {
        return this.instructors;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentAbbrev(String departmentAbbrev) {
        this.departmentAbbrev = departmentAbbrev;
    }

    public void setHeadOfDepartment(InstructorProfile headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(List<StudentProfile> students) {
        this.students = students;
    }

    public void setInstructors(Set<InstructorProfile> instructors) {
        this.instructors = instructors;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Department)) return false;
        final Department other = (Department) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$departmentName = this.getDepartmentName();
        final Object other$departmentName = other.getDepartmentName();
        if (this$departmentName == null ? other$departmentName != null : !this$departmentName.equals(other$departmentName))
            return false;
        final Object this$departmentAbbrev = this.getDepartmentAbbrev();
        final Object other$departmentAbbrev = other.getDepartmentAbbrev();
        if (this$departmentAbbrev == null ? other$departmentAbbrev != null : !this$departmentAbbrev.equals(other$departmentAbbrev))
            return false;
        final Object this$headOfDepartment = this.getHeadOfDepartment();
        final Object other$headOfDepartment = other.getHeadOfDepartment();
        if (this$headOfDepartment == null ? other$headOfDepartment != null : !this$headOfDepartment.equals(other$headOfDepartment))
            return false;
        final Object this$faculty = this.getFaculty();
        final Object other$faculty = other.getFaculty();
        if (this$faculty == null ? other$faculty != null : !this$faculty.equals(other$faculty)) return false;
        final Object this$courses = this.getCourses();
        final Object other$courses = other.getCourses();
        if (this$courses == null ? other$courses != null : !this$courses.equals(other$courses)) return false;
        final Object this$students = this.getStudents();
        final Object other$students = other.getStudents();
        if (this$students == null ? other$students != null : !this$students.equals(other$students)) return false;
        final Object this$instructors = this.getInstructors();
        final Object other$instructors = other.getInstructors();
        if (this$instructors == null ? other$instructors != null : !this$instructors.equals(other$instructors))
            return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Department;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $departmentName = this.getDepartmentName();
        result = result * PRIME + ($departmentName == null ? 43 : $departmentName.hashCode());
        final Object $departmentAbbrev = this.getDepartmentAbbrev();
        result = result * PRIME + ($departmentAbbrev == null ? 43 : $departmentAbbrev.hashCode());
        final Object $headOfDepartment = this.getHeadOfDepartment();
        result = result * PRIME + ($headOfDepartment == null ? 43 : $headOfDepartment.hashCode());
        final Object $faculty = this.getFaculty();
        result = result * PRIME + ($faculty == null ? 43 : $faculty.hashCode());
        final Object $courses = this.getCourses();
        result = result * PRIME + ($courses == null ? 43 : $courses.hashCode());
        final Object $students = this.getStudents();
        result = result * PRIME + ($students == null ? 43 : $students.hashCode());
        final Object $instructors = this.getInstructors();
        result = result * PRIME + ($instructors == null ? 43 : $instructors.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    public String toString() {
        return "Department(id=" + this.getId() + ", departmentName=" + this.getDepartmentName() + ", departmentAbbrev=" + this.getDepartmentAbbrev() + ", headOfDepartment=" + this.getHeadOfDepartment() + ", faculty=" + this.getFaculty() + ", courses=" + this.getCourses() + ", students=" + this.getStudents() + ", instructors=" + this.getInstructors() + ", createdAt=" + this.getCreatedAt() + ")";
    }
}
