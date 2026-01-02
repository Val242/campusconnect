package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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
    @OneToOne(
            optional = true
    )
    @JoinColumn(
            name = "head_instructor_id",
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
    @CreationTimestamp
    private LocalDateTime createdAt;

}
