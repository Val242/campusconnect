package valycodes.campusconnect.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "_user",  // original table name
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Owning side
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "studentProfile") // FK column in User table
    private StudentProfile studentProfile;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "instructorProfile") // FK column in User table
    private InstructorProfile instructorProfile;

    // ───────────────────────────────────────
    // Basic fields
    // ───────────────────────────────────────
    private String firstname;
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    @CreationTimestamp
    private LocalDateTime createdAt;

    // ───────────────────────────────────────
    // Constructors
    // ───────────────────────────────────────
    public User() {
    }

    public User(Integer id, StudentProfile studentProfile,InstructorProfile instructorProfile, String firstname, String lastname,
                String email, String password, Role role,LocalDateTime createdAt) {
        this.id = id;
        this.studentProfile = studentProfile;
        this.instructorProfile = instructorProfile;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // ───────────────────────────────────────
    // Spring Security UserDetails
    // ───────────────────────────────────────
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // ───────────────────────────────────────
    // equals, hashCode, toString
    // ───────────────────────────────────────
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", studentProfile=" + studentProfile +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public InstructorProfile getInstructorProfile() {
        return instructorProfile;
    }

    public void setInstructorProfile(InstructorProfile instructorProfile) {
        this.instructorProfile = instructorProfile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static class UserBuilder {
        private Integer id;
        private StudentProfile studentProfile;
        InstructorProfile instructorProfile;
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private Role role;
        private LocalDateTime createdAt;

        UserBuilder() {
        }

        public UserBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder studentProfile(StudentProfile studentProfile) {
            this.studentProfile = studentProfile;
            return this;
        }

        public UserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this.id, this.studentProfile, this.instructorProfile,this.firstname, this.lastname, this.email, this.password, this.role, this.createdAt);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", studentProfile=" + this.studentProfile + ", instructor-profile="+ this.instructorProfile +", firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ")";
        }
    }
}
