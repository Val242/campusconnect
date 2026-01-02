package valycodes.campusconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;



    @Column(unique = true, nullable = false)
    private Integer matriculationNumber;
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;
    private String faculty;
    private String level;



}