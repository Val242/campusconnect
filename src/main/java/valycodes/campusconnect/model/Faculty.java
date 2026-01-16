package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "faculties")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Faculty {
    @Id
    @GeneratedValue
    private Integer id;
    private String facultyName;
    @Column(
            unique = true,
            length = 10
    )
    private String facultyAbbrev;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "dean_id",
            unique = true
    )
    private InstructorProfile dean;
    @OneToMany(
            mappedBy = "faculty",
           fetch = FetchType.LAZY
    )
    private List<Department> departments;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Integer getId() {
        return this.id;
    }

    public String getFacultyName() {
        return this.facultyName;
    }

    public String getFacultyAbbrev() {
        return this.facultyAbbrev;
    }

    public InstructorProfile getDean() {
        return this.dean;
    }

    public List<Department> getDepartments() {
        return this.departments;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setFacultyAbbrev(String facultyAbbrev) {
        this.facultyAbbrev = facultyAbbrev;
    }

    public void setDean(InstructorProfile dean) {
        this.dean = dean;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Faculty)) return false;
        final Faculty other = (Faculty) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$facultyName = this.getFacultyName();
        final Object other$facultyName = other.getFacultyName();
        if (this$facultyName == null ? other$facultyName != null : !this$facultyName.equals(other$facultyName))
            return false;
        final Object this$facultyAbbrev = this.getFacultyAbbrev();
        final Object other$facultyAbbrev = other.getFacultyAbbrev();
        if (this$facultyAbbrev == null ? other$facultyAbbrev != null : !this$facultyAbbrev.equals(other$facultyAbbrev))
            return false;
        final Object this$dean = this.getDean();
        final Object other$dean = other.getDean();
        if (this$dean == null ? other$dean != null : !this$dean.equals(other$dean)) return false;
        final Object this$departments = this.getDepartments();
        final Object other$departments = other.getDepartments();
        if (this$departments == null ? other$departments != null : !this$departments.equals(other$departments))
            return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Faculty;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $facultyName = this.getFacultyName();
        result = result * PRIME + ($facultyName == null ? 43 : $facultyName.hashCode());
        final Object $facultyAbbrev = this.getFacultyAbbrev();
        result = result * PRIME + ($facultyAbbrev == null ? 43 : $facultyAbbrev.hashCode());
        final Object $dean = this.getDean();
        result = result * PRIME + ($dean == null ? 43 : $dean.hashCode());
        final Object $departments = this.getDepartments();
        result = result * PRIME + ($departments == null ? 43 : $departments.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    public String toString() {
        return "Faculty(id=" + this.getId() + ", facultyName=" + this.getFacultyName() + ", facultyAbbrev=" + this.getFacultyAbbrev() + ", dean=" + this.getDean() + ", departments=" + this.getDepartments() + ", createdAt=" + this.getCreatedAt() + ")";
    }
}

