package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "faculties")
@Entity
@Data
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
    @OneToOne
    @JoinColumn(
            name = "dean_id",
            unique = true
    )
    private InstructorProfile dean;
    @OneToMany(
            fetch = FetchType.LAZY
    )
    private List<Department> departments;
    @CreationTimestamp
    private LocalDateTime createdAt;
}

