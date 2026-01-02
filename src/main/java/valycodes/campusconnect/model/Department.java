package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "department")
@Entity
@Data
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

}
