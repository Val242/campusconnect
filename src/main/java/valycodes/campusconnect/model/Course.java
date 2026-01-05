package valycodes.campusconnect.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private Integer creditUnits;

    private String level;

    private String semester;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private InstructorProfile instructor;  // current course instructor / lecturer

    @OrderBy("createdAt ASC")
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<StudentProfile> students = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Course(Integer id, String courseCode, String title, String description, Integer creditUnits, String level, String semester, Department department, InstructorProfile instructor, Set<StudentProfile> students, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.creditUnits = creditUnits;
        this.level = level;
        this.semester = semester;
        this.department = department;
        this.instructor = instructor;
        this.students = students;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Course() {
    }

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getCreditUnits() {
        return this.creditUnits;
    }

    public String getLevel() {
        return this.level;
    }

    public String getSemester() {
        return this.semester;
    }

    public Department getDepartment() {
        return this.department;
    }

    public InstructorProfile getInstructor() {
        return this.instructor;
    }

    public Set<StudentProfile> getStudents() {
        return this.students;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreditUnits(Integer creditUnits) {
        this.creditUnits = creditUnits;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setInstructor(InstructorProfile instructor) {
        this.instructor = instructor;
    }

    public void setStudents(Set<StudentProfile> students) {
        this.students = students;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Course)) return false;
        final Course other = (Course) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$courseCode = this.getCourseCode();
        final Object other$courseCode = other.getCourseCode();
        if (this$courseCode == null ? other$courseCode != null : !this$courseCode.equals(other$courseCode))
            return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$creditUnits = this.getCreditUnits();
        final Object other$creditUnits = other.getCreditUnits();
        if (this$creditUnits == null ? other$creditUnits != null : !this$creditUnits.equals(other$creditUnits))
            return false;
        final Object this$level = this.getLevel();
        final Object other$level = other.getLevel();
        if (this$level == null ? other$level != null : !this$level.equals(other$level)) return false;
        final Object this$semester = this.getSemester();
        final Object other$semester = other.getSemester();
        if (this$semester == null ? other$semester != null : !this$semester.equals(other$semester)) return false;
        final Object this$department = this.getDepartment();
        final Object other$department = other.getDepartment();
        if (this$department == null ? other$department != null : !this$department.equals(other$department))
            return false;
        final Object this$instructor = this.getInstructor();
        final Object other$instructor = other.getInstructor();
        if (this$instructor == null ? other$instructor != null : !this$instructor.equals(other$instructor))
            return false;
        final Object this$students = this.getStudents();
        final Object other$students = other.getStudents();
        if (this$students == null ? other$students != null : !this$students.equals(other$students)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Course;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $courseCode = this.getCourseCode();
        result = result * PRIME + ($courseCode == null ? 43 : $courseCode.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $creditUnits = this.getCreditUnits();
        result = result * PRIME + ($creditUnits == null ? 43 : $creditUnits.hashCode());
        final Object $level = this.getLevel();
        result = result * PRIME + ($level == null ? 43 : $level.hashCode());
        final Object $semester = this.getSemester();
        result = result * PRIME + ($semester == null ? 43 : $semester.hashCode());
        final Object $department = this.getDepartment();
        result = result * PRIME + ($department == null ? 43 : $department.hashCode());
        final Object $instructor = this.getInstructor();
        result = result * PRIME + ($instructor == null ? 43 : $instructor.hashCode());
        final Object $students = this.getStudents();
        result = result * PRIME + ($students == null ? 43 : $students.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    public String toString() {
        return "Course(id=" + this.getId() + ", courseCode=" + this.getCourseCode() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", creditUnits=" + this.getCreditUnits() + ", level=" + this.getLevel() + ", semester=" + this.getSemester() + ", department=" + this.getDepartment() + ", instructor=" + this.getInstructor() + ", students=" + this.getStudents() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }

    public static class CourseBuilder {
        private Integer id;
        private String courseCode;
        private String title;
        private String description;
        private Integer creditUnits;
        private String level;
        private String semester;
        private Department department;
        private InstructorProfile instructor;
        private Set<StudentProfile> students;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        CourseBuilder() {
        }

        public CourseBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public CourseBuilder courseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public CourseBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CourseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CourseBuilder creditUnits(Integer creditUnits) {
            this.creditUnits = creditUnits;
            return this;
        }

        public CourseBuilder level(String level) {
            this.level = level;
            return this;
        }

        public CourseBuilder semester(String semester) {
            this.semester = semester;
            return this;
        }

        public CourseBuilder department(Department department) {
            this.department = department;
            return this;
        }

        public CourseBuilder instructor(InstructorProfile instructor) {
            this.instructor = instructor;
            return this;
        }

        public CourseBuilder students(Set<StudentProfile> students) {
            this.students = students;
            return this;
        }

        public CourseBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CourseBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Course build() {
            return new Course(this.id, this.courseCode, this.title, this.description, this.creditUnits, this.level, this.semester, this.department, this.instructor, this.students, this.createdAt, this.updatedAt);
        }

        public String toString() {
            return "Course.CourseBuilder(id=" + this.id + ", courseCode=" + this.courseCode + ", title=" + this.title + ", description=" + this.description + ", creditUnits=" + this.creditUnits + ", level=" + this.level + ", semester=" + this.semester + ", department=" + this.department + ", instructor=" + this.instructor + ", students=" + this.students + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}