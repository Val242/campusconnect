package valycodes.campusconnect.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(
        name = "_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        }
)
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
}
