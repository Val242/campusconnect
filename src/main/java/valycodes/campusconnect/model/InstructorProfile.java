package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "instructor_profiles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorProfile {

    @Id
    @GeneratedValue
    private Integer id;




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
}
